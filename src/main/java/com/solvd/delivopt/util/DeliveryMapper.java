package com.solvd.delivopt.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.delivopt.model.Delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DeliveryMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LogManager.getLogger(DeliveryMapper.class);

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static String toJson(Delivery delivery) throws Exception {
        return objectMapper.writeValueAsString(delivery);
    }

    public static Delivery fromJson(String json) throws Exception {
        return objectMapper.readValue(json, Delivery.class);
    }

    public static void writeJsonToFile(Delivery delivery, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), delivery);
        log.info("JSON written to file: {}", filePath);
    }
}
