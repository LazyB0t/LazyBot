package ru.berrywoodfamily;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMBot {

    private Document document;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;

    public DOMBot() {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        File file = new File("src/main/resources/Bot.xml");
        System.out.println(file.canRead());
        try {
            document = builder.parse(file);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Bot getBot(){
        return new Bot(document);
    }
}
