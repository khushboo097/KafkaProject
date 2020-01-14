package com.coviam.training.kafka.service;

public  class Reader implements Runnable {

    @Override
    public void run() {
        try {

            CSVFileHandler csvFileHandler = new CSVFileHandler();

            csvFileHandler.read();

        } catch (Exception e) {

        }

    }

    public static class XmlReader implements Runnable {

        @Override
        public void run() {
            try {
                XMLFileHandler xmlFileHandler = new XMLFileHandler();
                xmlFileHandler.read();
            } catch (Exception e) {

            }
        }
    }
    public static class JsonReader implements Runnable {
        @Override
        public void run() {
            try {
                JSONFileHandler jsonFileHandler = new JSONFileHandler();
           //     System.out.println("here ----------");
                jsonFileHandler.read();

            } catch (Exception e) {

            }

        }
    }
}
