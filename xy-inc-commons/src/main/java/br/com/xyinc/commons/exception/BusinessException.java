package br.com.xyinc.commons.exception;

import br.com.xyinc.commons.response.GenericResponse;
import br.com.xyinc.commons.response.MessageResponse;

/**
 * Classe que trata Business Exceptions.
 * 
 * @author tiago
 *
 */

public class BusinessException extends XyException {

	private static final long serialVersionUID = 256342376837574866L;

	public BusinessException() {
		super(new GenericResponse<>());
	}

	public BusinessException(String message) {
		super(message, new GenericResponse<>());
	}

	public BusinessException(MessageResponse error) {
		super(new GenericResponse<>().withError(error));
	}

	public BusinessException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public BusinessException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
