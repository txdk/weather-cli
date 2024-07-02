package com.txdk;

import java.io.IOException;
import java.io.File;

import com.txdk.api.WeatherService;
import com.txdk.data.WeatherReport;
import com.txdk.file.FileHandler;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Command(
    name = "weather", 
    version = "0.1",
    description = "Simple cli for printing a weather report in the terminal. Powered by Weather API.",
    mixinStandardHelpOptions = true
)
public class App implements Runnable {

    @Parameters(paramLabel = "<location>", defaultValue = "Adelaide", description = "Location of weather report")
    private String location = "Adelaide";

    @Option(names = {"-k", "--key"}, description = "Specify API key at runtime", interactive = true)
    private char[] apiKey;

    File keyFile = new File(System.getProperty("user.home"), ".weatherkey");
    FileHandler fileHandler = new FileHandler(keyFile);

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        if (apiKey == null) {
            if (keyFile.isFile()) {
                try {
                    apiKey = fileHandler.readFromFile().toCharArray();
                }
                catch (IOException ioException) {
                    System.out.println("Error reading key file");
                }
            }
            else {
                System.out.println("API key must be set");
                return;
            }    
        }

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherReport> call = weatherService.getWeather(new String(apiKey), location);

        try {
            Response<WeatherReport> response = call.execute();
            if (response.code() == HttpStatus.FORBIDDEN) {
                System.out.println("API key invalid.");
                return;
            }
            WeatherReport weatherReport = response.body();
            System.out.println(
                "Location: " + weatherReport.getLocation().getName() + ", " +
                weatherReport.getLocation().getCountry()
            );
            System.out.println(
                "Weather: " + weatherReport.getCurrent().getCondition().getText() + ", " +
                weatherReport.getCurrent().getTempC() + "°C"
            );
        }
        catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    @Command(
        name = "auth",
        description = "Cache API key so it does not need to be re-entered for every request"
    )
    public void setAPIKey() {
        apiKey = System.console().readPassword("Enter API key: ");
        try {
            fileHandler.writeToFile(new String(apiKey));
            System.out.println("API key set");
        }
        catch (IOException ioException) {
            System.out.println("Error storing API key");
        }
    }
}