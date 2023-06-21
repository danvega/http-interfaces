package dev.danvega.contentservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(IllegalStateException.class)
    public void handleTimeout(HttpServletRequest request, Exception e) {
        log.info(e.getMessage());
        log.info("Connection timeout while calling service {}",request.getRequestURI());
    }

}
