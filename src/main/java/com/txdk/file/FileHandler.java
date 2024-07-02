package com.txdk.file;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FileHandler {

    private File file;

    public void writeToFile(String contents) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(contents);
        }   
    }

    public String readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        }
    }
    
}
