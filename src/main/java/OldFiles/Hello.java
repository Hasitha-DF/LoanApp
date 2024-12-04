//package org.example.controllers;
//
//
//import com.sun.net.httpserver.HttpServer;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//
//public class Hello {
//
//    final int serverPort = 8080;
//
//    public void responseHello() throws IOException {
//
//        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort),0);
//
//        server.createContext("/api/hello" , new SaveDataHCHandler());
//    }
//
//    //cant be accessed directly
//    public Hello() {
//
//
//    }
//
//}
