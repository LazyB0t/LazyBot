package ru.lazybot;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.lazybot.elements.Bot;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class DOMBot {
    private Document document;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;

    public DOMBot(String filePath) {
        this(new InputSource(filePath));
    }

    public DOMBot(InputStream is) {
        this(new InputSource(is));
        try {
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DOMBot(InputSource inputSource) {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            document = builder.parse(inputSource);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Bot getBot() {
        return new Bot(document.getElementsByTagName("Bot").item(0));
    }
}
