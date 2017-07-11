package br.com.xyinc.commons.exception;

import br.com.xyinc.commons.response.GenericResponse;
import br.com.xyinc.commons.response.MessageResponse;
import br.com.xyinc.commons.response.Status;

/**
 * Classe que trata InternalErrorExceptions.
 * 
 * @author tiago
 *
 */

public class InternalErrorException extends XyException {

	private static final long serialVersionUID = 3032591975427976040L;

	public InternalErrorException() {
		super(new GenericResponse<>());
	}

	public InternalErrorException(String message) {
		super(message, new GenericResponse<>().withError(new MessageResponse(message)).withStatus(Status.ERROR));
	}

	public InternalErrorException(MessageResponse error) {
		super(new GenericResponse<>().withError(error));
	}

	public InternalErrorException(GenericResponse<?> genericResponse) {
		super(genericResponse);
	}

	public InternalErrorException(String message, Throwable t) {
		super(message, t, new GenericResponse<>());
	}

}