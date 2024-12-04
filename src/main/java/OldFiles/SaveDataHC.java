//package org.example.controllers;
//
//import com.sun.net.httpserver.HttpServer;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//
//public class SaveDataHC {
//
//    public   SaveDataHC() {
//    }
//
//    final int serverPort = 8080;
//
//    public void saveName() throws IOException {
//
//        HttpServer httpServer = HttpServer.create(new InetSocketAddress(serverPort) , 0);
//
//        httpServer.createContext ( "/api/save" , new SaveDataHCHandler());
//        httpServer.setExecutor(null); // Use the default executor
//        httpServer.start();
//
////                exchange -> {
////            String name = null;
////            int id = 15;
////            Client client;
////
////            exchange.sendResponseHeaders(200,name.getBytes().length );
////            System.out.println(name.getBytes().length);
////            OutputStream outputStream = exchange.getResponseBody();
////            outputStream.write(name.getBytes());
////
////        }
//    }
//}
