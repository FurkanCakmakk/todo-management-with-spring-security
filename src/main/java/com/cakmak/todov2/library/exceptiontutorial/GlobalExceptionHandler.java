package com.cakmak.todov2.library.exceptiontutorial;

import com.cakmak.todov2.library.rest.BaseController;
import com.cakmak.todov2.library.rest.MetaResponse;
import com.cakmak.todov2.library.rest.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Response<MetaResponse> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return respond(MetaResponse.of("444" , resourceNotFoundException.getMessage()));
    }
}
