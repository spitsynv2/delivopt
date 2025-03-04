package com.solvd.delivopt.repo.impl.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.delivopt.model.Delivery;
import com.solvd.delivopt.repo.impl.wrapper.DeliveryListWrapper;
import com.solvd.delivopt.util.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonDeliveryImpl {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LogManager.getLogger(JacksonDeliveryImpl.class);
    private static final File READ_FROM_FILE = new File(ConfigLoader.getProperty("JSON_INPUT_FILE"));
    private static final File WRITE_TO_FILE = new File(ConfigLoader.getProperty("JSON_OUTPUT_FILE"));

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public String toJson(Delivery delivery) {
        try {
            return objectMapper.writeValueAsString(delivery);
        } catch (JsonProcessingException e) {
            log.error(e);
            return "";
        }
    }

    public String listToJson(List<Delivery> deliveries) {
        try {
            return objectMapper.writeValueAsString(new DeliveryListWrapper(deliveries));
        } catch (JsonProcessingException e) {
            log.error(e);
            return "";
        }
    }

    public Delivery fromJson(String json) {
        try {
            return objectMapper.readValue(json, Delivery.class);
        } catch (JsonProcessingException e) {
            log.error(e);
            return null;
        }
    }

    public List<Delivery> listFromJson(String json) {
        try {
            return objectMapper.readValue(json, DeliveryListWrapper.class).getDeliveries();
        } catch (JsonProcessingException e) {
            log.error(e);
            return null;
        }
    }

    public void writeToJsonFile(Delivery delivery) {
        try {
            objectMapper.writeValue(WRITE_TO_FILE, delivery);
            log.info("JSON written to file: {}", WRITE_TO_FILE.getPath());
        } catch (IOException e) {
            log.error(e);
        }
    }

    public void writeListToJsonFile(List<Delivery> deliveries) {
        try {
            objectMapper.writeValue(WRITE_TO_FILE, new DeliveryListWrapper(deliveries));
            log.info("JSON list written to file: {}", WRITE_TO_FILE.getPath());
        } catch (IOException e) {
            log.error(e);
        }
    }

    public Delivery fromJsonFile(String filepath) {
        try {
            return objectMapper.readValue(new File(filepath), Delivery.class);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    public List<Delivery> listFromJsonFile() {
        try {
            return objectMapper.readValue(READ_FROM_FILE, DeliveryListWrapper.class).getDeliveries();
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }
}

