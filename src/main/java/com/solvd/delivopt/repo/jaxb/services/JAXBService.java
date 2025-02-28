package com.solvd.delivopt.repo.jaxb.services;

import com.solvd.delivopt.repo.jaxb.Delivery;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class JAXBService{

    public String marshalDeliveries(List<Delivery> deliveries) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Delivery.class);
        Marshaller marshaller = context.createMarshaller();


        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        StringWriter writer = new StringWriter();


        for (Delivery delivery : deliveries) {
            marshaller.marshal(delivery, writer);
        }

        return writer.toString();
    }

    public List<Delivery> unmarshalDeliveries(String xml) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Delivery.class);


        Unmarshaller unmarshaller = context.createUnmarshaller();


        StringReader reader = new StringReader(xml);


        List<Delivery> deliveries = (List<Delivery>) unmarshaller.unmarshal(reader);

        return deliveries;
    }
}