//package org.example.controllers;
//
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//
//import java.io.DataInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.nio.charset.StandardCharsets;
//
//public class SaveDataHCHandler implements HttpHandler {
//
//    public SaveDataHCHandler() {
//
//    }
//
//    private String extractValue(String json) {
//        if (json.contains("name")) {
//            return json.split(":")[1].replace("\"", "").replace("}", "").trim();
//        }
//        return "No value provided";
//    }
//
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        String response = "";
//        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
//
//            //read req body
//            InputStream inputStream = exchange.getRequestBody();
//            byte[] bytes = new byte[inputStream.available()];
//            DataInputStream dataInputStream = new DataInputStream(inputStream);
//            String requestBody = new String(dataInputStream.readFully(bytes), StandardCharsets.UTF_8);
//
//            String value = extractValue(requestBody);
//            response = value;
//            exchange.sendResponseHeaders(200, response.getBytes().length);
//            // response outputting as a stream of bytes
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//
//            exchange.close();
//        }
//    }
//}
