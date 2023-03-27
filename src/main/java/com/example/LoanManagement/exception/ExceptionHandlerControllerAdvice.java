package com.example.LoanManagement.exception;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;


@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ModelAndView handleResourceNotFound(final ApplicationException exception, final HttpServletRequest request, final Model model) {

        int statusCode = 0;
        ErrorResponse err = new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return null;
            }

            @Override
            public ProblemDetail getBody() {
                return null;
            }
        };

        ModelAndView mav = new ModelAndView();
        err.setErrorMessage(exception.getMessage());
        err.setRequestedURI("http://localhost:8085/" + request.getRequestURI());
        try {
            URL url = new URL(err.getRequestedURI());
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            statusCode = 500;//http.getResponseCode();
            mav.addObject("code", statusCode);
            mav.addObject("cur time", new Date());
            mav.addObject("message", err.getErrorMessage());
            mav.setViewName("error");
        } catch (IOException e) {
            System.out.println(e);
        }
        return mav;

    }
}
