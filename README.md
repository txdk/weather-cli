# Simple Weather CLI

A simple command line interface for obtaining a weather forecast within the terminal. Powered by [Weather API](https://www.weatherapi.com/).

# Installation

This project was built using Java 17, which is required to build and install the application.

To install, simply run the install script:
```sh
./install.sh
```

Then restart your terminal or source the changes via
```sh
source ~/.bash_profile
```

# Usage

Create a free account at [WeatherAPI.com](https://www.weatherapi.com/) and generate an API key. To cache the key so it does not need to be entered each time the CLI is invoked, run
```sh
weather auth
```

Once cached, you can obtain a print out of the current weather using
```sh
weather
```

The above command shows the report for the default set location. To change the location, supply the location as an argument
```sh
weather <location>
```

# TO DO
- Forecasts
- Change default location (set config/preferences)
- Add more details to reports (verbose mode?)