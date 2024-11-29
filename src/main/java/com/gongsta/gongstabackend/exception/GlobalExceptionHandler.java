//package com.gongsta.gongstabackend.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    // 1. RuntimeException 예외 처리
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntimeException(RuntimeException ex, WebRequest request) {
//        // Swagger 요청에 대해서는 예외 처리하지 않음
//        if (isSwaggerRequest(request)) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//    }
//
//    // 2. General Exception 예외 처리
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex, WebRequest request) {
//        // Swagger 요청에 대해서는 예외 처리하지 않음
//        if (isSwaggerRequest(request)) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류가 발생했습니다.");
//    }
//
//    // Swagger 요청을 판별하는 helper method
//    private boolean isSwaggerRequest(WebRequest request) {
//        String path = request.getDescription(false);
//        return path.contains("/swagger-ui") || path.contains("/v3/api-docs");
//    }
//}
