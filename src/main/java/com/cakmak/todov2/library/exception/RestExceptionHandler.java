package com.cakmak.todov2.library.exception;

import com.cakmak.todov2.library.enums.MessageCodes;
import com.cakmak.todov2.library.rest.BaseController;
import com.cakmak.todov2.library.rest.MetaResponse;
import com.cakmak.todov2.library.rest.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends BaseController {
    private final MessageSource messageSource;

    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(CoreException.class)
    public Response<MetaResponse> handleCoreException(CoreException coreException, Locale locale) {
        MessageCodes messageCode = coreException.getCode();
        String message = messageSource.getMessage(messageCode.getMessage(), coreException.getArgs(), locale);
        StringBuilder sb = new StringBuilder("[CoreException] messageCode: ");
        sb.append(messageCode.getCode());
        sb.append(" , message: ");
        sb.append(message);
        log.error(sb.toString());
        return respond(MetaResponse.of(messageCode.getCode(),message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<MetaResponse> handleValidationErrors(MethodArgumentNotValidException ex, Locale locale) {
        String error = ex.getBindingResult().getFieldErrors()
                .stream().findFirst().map(FieldError::getDefaultMessage).orElse(MessageCodes.BAD_REQUEST.getMessage());
        String message = messageSource.getMessage(error, null, locale);
        StringBuilder sb = new StringBuilder("[MethodArgumentNotValidException] code: ");
        sb.append(MessageCodes.BAD_REQUEST);
        sb.append(" , message: ");
        sb.append(message);
        log.error(sb.toString());
        return respond(MetaResponse.of(MessageCodes.BAD_REQUEST.getCode(),message));
    }
}
