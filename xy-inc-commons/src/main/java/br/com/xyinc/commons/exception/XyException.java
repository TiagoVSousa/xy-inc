package br.com.xyinc.commons.exception;

import br.com.xyinc.commons.response.GenericResponse;

/**
 * Classe que trata as XYExceptions.
 * 
 * @author tiago
 *
 */

public class XyException extends RuntimeException {

	private static final long serialVersionUID = 6173388998024434732L;

	private GenericResponse<?> genericResponse = new GenericResponse<>();

	public XyException(GenericResponse<?> genericResponse) {
		this.genericResponse = genericResponse;
	}

	public XyException(String message) {
		super(message);
	}

	public XyException(String message, GenericResponse<?> genericResponse) {
		super(message);
		this.genericResponse = genericResponse;
	}

	public XyException(String message, Throwable cause) {
		super(message, cause);
	}

	public XyException(String message, Throwable cause, GenericResponse<?> genericResponse) {
		super(message, cause);
		this.genericResponse = genericResponse;
	}

	public XyException(Throwable cause) {
		super(cause);
	}

	public GenericResponse<?> getGenericResponse() {
		return genericResponse;
	}

	public void setGenericResponse(GenericResponse<?> genericResponse) {
		this.genericResponse = genericResponse;
	}
}