package com.coviam.training.kafka.service;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Controller {
    private JSONFileHandler jsonFileHandler = new JSONFileHandler();
    private CSVFileHandler csvFileHandler = new CSVFileHandler();
    private XMLFileHandler xmlFileHandler = new XMLFileHandler();

    public Controller() throws IOException, ParseException {
    }

    public static void main(String[] args) throws Exception {
        for (int index = 0; index < 100; index++) {

            Reader.JsonReader jsonRead = new Reader.JsonReader();
            Reader csvRead = new Reader();
            Reader.XmlReader xmlRead = new Reader.XmlReader();

            Thread thread1 = new Thread(xmlRead);
            Thread thread2 = new Thread(csvRead);
            Thread thread3 = new Thread(jsonRead);

            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();

        }


    }

}



