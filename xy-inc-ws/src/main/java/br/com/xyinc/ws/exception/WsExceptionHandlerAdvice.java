package br.com.xyinc.ws.exception;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.xyinc.commons.exception.ArgumentsException;
import br.com.xyinc.commons.exception.BusinessException;
import br.com.xyinc.commons.exception.InternalErrorException;
import br.com.xyinc.commons.response.GenericResponse;

/**
 * Captura as excecoes
 * @author tiago
 *
 */
@ControllerAdvice
public class WsExceptionHandlerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(WsExceptionHandlerAdvice.class);
	
	/**
	 * Substitui caracteres especiais.
	 * 
	 * @param response
	 * @return
	 */
	private String escapeChars(GenericResponse<?> response) {
		if(response == null) return "";
		String str = response.toString().replaceAll("\\r\\n", "");
		return StringEscapeUtils.escapeJson(str);
	}
	
	/**
	 * Configura o header.
	 * 
	 * @return objeto {@code HttpHeaders}
	 */
	protected HttpHeaders headers() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return httpHeaders;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ArgumentsException.class)
	public ResponseEntity<GenericResponse<?>> argumentsException(ArgumentsException e) {
		
		logger.error("Arguments Request Error {}", escapeChars(e.getGenericResponse()));
		
		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<GenericResponse<?>> badRequestException(BusinessException e) {
		
		logger.error("Business Exception Error {}", escapeChars(e.getGenericResponse()));

		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalErrorException.class)
	public ResponseEntity<GenericResponse<?>> internalErrorException(InternalErrorException e) {
		
		logger.error("Internal Server Error {}", escapeChars(e.getGenericResponse()));
		
		return new ResponseEntity<>(e.getGenericResponse(), headers(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
