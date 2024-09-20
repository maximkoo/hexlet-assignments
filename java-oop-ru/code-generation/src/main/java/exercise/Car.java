package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static Car deserialize(String str) {
        try {
            Car car = new ObjectMapper().readValue(str, Car.class);
            return car;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
