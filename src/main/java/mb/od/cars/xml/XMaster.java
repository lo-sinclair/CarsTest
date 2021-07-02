package mb.od.cars.xml;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class XMaster {

    public int countOfUniqueNames (String dataFile) {
        int count = 0;

        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(dataFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            Set<String> namesSet = new HashSet<>();

            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();

                if(event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if(startElement.getName().getLocalPart().equals("modification")) {
                        String val = startElement.getAttributeByName(QName.valueOf("name")).getValue();
                        namesSet.add(val);
                     }
                }
            }
            count = namesSet.size();

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return count;
    }



}
