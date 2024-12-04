//package org.example.MAP;
//
//
//import java.util.*;
//import java.util.regex.Pattern;
//
//public class DataMapper {
//
//
//    public static Map<String , List<String>> dataQuery(String data){
//        if (data==null || "".equals(data)){
//            return Collections.emptyMap();
//        }
//        return Pattern.compile("&").splitAsStream(data)
//                .map(s-> Arrays.stream(Arrays.copyOf(s.split("="),2))
//                        .collect(gr));
//    }
//
//}
