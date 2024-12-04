//package org.example.exception;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//
//@Provider
//public class GlobalExceptionHandler implements ExceptionMapper<Exception> {
//
//    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @Override
//    public Response toResponse(Exception exception) {
//        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                .entity("{\"error\": \"" + exception.toString() + "\"}")
//                .type(MediaType.APPLICATION_JSON)
//                .build();
//    }
//
//}
