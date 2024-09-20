package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(String.valueOf(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //String json = new ObjectMapper().writeValueAsString(car);
            String json = car.serialize();
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        //File f = new File(String.valueOf(path));
        String currentLine;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(String.valueOf(path)));
            currentLine = reader.readLine();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.deserialize(currentLine);
    }
}
// END
