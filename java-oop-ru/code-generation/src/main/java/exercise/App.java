package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        String result = car.serialize();
        try {
            Files.writeString(path, result, StandardCharsets.UTF_8 );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Car extract(Path path) {
        String result;
        try {
            result = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.unserialize(result);
    }
}
// END
