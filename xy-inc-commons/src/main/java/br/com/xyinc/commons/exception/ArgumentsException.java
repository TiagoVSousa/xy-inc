package br.com.xyinc.commons.exception;

import java.util.List;

import br.com.xyinc.commons.response.GenericResponse;
import br.com.xyinc.commons.response.MessageResponse;

/**
 * Classe que trata Argument Exceptions.
 * 
 * @author tiago
 *
 */

public class ArgumentsException extends XyException {

	private static final long serialVersionUID = -5201936209779440433L;

	public ArgumentsException() {
		super(new GenericResponse<>());
	}

	public ArgumentsException(String message) {
		super(message, new GenericResponse<>());
	}

	public ArgumentsException(MessageResponse error) {
		super(new GenericResponse<>().appendError(error));
	}

	public ArgumentsException(List<MessageResponse> errors) {
		super(new GenericResponse<>().withErrors(errors));
	}

	public ArgumentsException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public ArgumentsException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}

}