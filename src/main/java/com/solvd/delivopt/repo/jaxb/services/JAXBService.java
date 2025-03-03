package com.solvd.delivopt.repo.jaxb.services;


import com.solvd.delivopt.repo.jaxb.Delivery;
import jakarta.xml.bind.*;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class JAXBService {

    public String marshalDeliveries(List<Delivery> deliveries) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DeliveryListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        DeliveryListWrapper wrapper = new DeliveryListWrapper();
        wrapper.setDeliveries(deliveries);

        StringWriter writer = new StringWriter();
        marshaller.marshal(wrapper, writer);

        return writer.toString();
    }

    public List<Delivery> unmarshalDeliveries(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DeliveryListWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(xml);


        DeliveryListWrapper wrapper = (DeliveryListWrapper) unmarshaller.unmarshal(reader);
        return wrapper.getDeliveries();
    }
}
