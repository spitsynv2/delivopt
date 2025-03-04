package com.solvd.delivopt.repo.impl.jaxb;

import com.solvd.delivopt.model.Delivery;
import com.solvd.delivopt.repo.impl.wrapper.DeliveryListWrapper;
import com.solvd.delivopt.util.ConfigLoader;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JaxbDeliveryImpl {
    private static final Logger log = LogManager.getLogger(JaxbDeliveryImpl.class);

    private static final File READ_FROM_FILE = new File(ConfigLoader.getProperty("XML_INPUT_FILE"));
    private static final File WRITE_TO_FILE = new File(ConfigLoader.getProperty("XML_OUTPUT_FILE"));

    public String marshalDeliveries(List<Delivery> deliveries) {
        if (deliveries == null || deliveries.isEmpty()) {
            return "";
        }

        DeliveryListWrapper wrapper = new DeliveryListWrapper(deliveries);

        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(DeliveryListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(wrapper, writer);
            marshaller.marshal(wrapper, WRITE_TO_FILE);
        } catch (JAXBException e) {
            log.error(e);
            return "";
        }

        return writer.toString();
    }

    public List<Delivery> unmarshalDeliveries()  {
        List<Delivery> deliveries = new ArrayList<>();

        try {
            JAXBContext context = JAXBContext.newInstance(DeliveryListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            DeliveryListWrapper wrapper = (DeliveryListWrapper) unmarshaller.unmarshal(READ_FROM_FILE);
            deliveries = wrapper.getDeliveries();
        } catch (JAXBException e) {
            log.error(e);
            return deliveries;
        }

        return deliveries;
    }
}