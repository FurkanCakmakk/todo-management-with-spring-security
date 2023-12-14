package com.cakmak.todov2.library.exception;

import com.cakmak.todov2.library.enums.MessageCodes;
import com.cakmak.todov2.library.rest.BaseController;
import com.cakmak.todov2.library.rest.MetaResponse;
import com.cakmak.todov2.library.rest.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@RestControllerAdvice
public class RestExceptionHandler extends BaseController {
//    @ExceptionHandler(CoreException.class)
//    public Response<MetaResponse> handleCoreException(CoreException coreException) {
//        System.out.println("CoreException'dan gelen : " + coreException);
//        System.out.println("Core Exception'daki arg değerleri :  " + coreException.getArgs());
//
//        MessageCodes messageCode = coreException.getCode();
//        String message = coreException.getMessage() + coreException.getArgs();
//        System.out.println("Core Exception'dan gelen message :  " + coreException.getMessage());
//        return respond(MetaResponse.of(messageCode.getCode(), message));
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Response<MetaResponse> handleValidationErrors(MethodArgumentNotValidException ex, Locale locale) {
//        String error = ex.getBindingResult().getFieldErrors()
//                .stream().findFirst().map(FieldError::getDefaultMessage).orElse(MessageCodes.BAD_REQUEST.getMessage());
//        String message = messageSource.getMessage(error, null, locale);
//        StringBuilder sb = new StringBuilder("[MethodArgumentNotValidException] code: ");
//        sb.append(MessageCodes.BAD_REQUEST);
//        sb.append(" , message: ");
//        sb.append(message);
//        log.error(sb.toString());
//        return respond(MetaResponse.of(MessageCodes.BAD_REQUEST.getCode(), message));
//    }
}
