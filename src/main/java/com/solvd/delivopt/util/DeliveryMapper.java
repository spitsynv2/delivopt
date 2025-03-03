package com.solvd.delivopt.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.delivopt.model.Delivery;

import java.io.File;
import java.io.IOException;

public class DeliveryMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Enable pretty print for the JSON output
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Register the JavaTimeModule to handle LocalDateTime and other Java 8 date/time types
        objectMapper.registerModule(new JavaTimeModule());
    }

    // Method to convert Delivery object to JSON string
    public static String toJson(Delivery delivery) throws Exception {
        return objectMapper.writeValueAsString(delivery);
    }

    // Method to convert JSON string to Delivery object
    public static Delivery fromJson(String json) throws Exception {
        return objectMapper.readValue(json, Delivery.class);
    }

    // Method to write serialized JSON to a file
    public static void writeJsonToFile(Delivery delivery, String filePath) throws IOException {
        // Convert the Delivery object to JSON and write to the file
        objectMapper.writeValue(new File(filePath), delivery);
        System.out.println("JSON written to file: " + filePath);
    }
}
