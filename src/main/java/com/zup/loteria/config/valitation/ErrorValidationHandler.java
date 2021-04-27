package com.zup.loteria.config.valitation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zup.loteria.dto.ErrorFormDto;

@RestControllerAdvice
public class ErrorValidationHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDto> handle(MethodArgumentNotValidException exception){
		
		List<ErrorFormDto> dto = new ArrayList<>();
		exception.getBindingResult().getFieldErrors().forEach(e -> {
			//internationalization message
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			dto.add(new ErrorFormDto(e.getField(), message));
			
		});
		
		return dto;
	}
}
