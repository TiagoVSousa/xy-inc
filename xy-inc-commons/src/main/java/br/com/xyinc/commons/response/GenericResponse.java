package br.com.xyinc.commons.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.xyinc.commons.response.MessageResponse;

/**
 * Classe que contem Generic Response.
 * 
 * @author tiago
 *
 * @param <T>
 */

public class GenericResponse<T> implements Serializable {

	private static final long serialVersionUID = 8233769178834358135L;
	private Status status;
	private transient T result;
	private List<MessageResponse> errors;
	private MessageResponse error;

	public GenericResponse() {
		super();
	}

	public GenericResponse(T result) {
		this.result = result;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<MessageResponse> getErrors() {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<MessageResponse> errors) {
		this.errors = errors;
	}

	public MessageResponse getError() {
		return error;
	}

	public void setError(MessageResponse error) {
		this.error = error;
	}

	public GenericResponse<T> appendError(MessageResponse message) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(message);
		return this;
	}

	public GenericResponse<T> appendError(String code) {
		appendError(new MessageResponse(code, ""));
		return this;
	}

	public GenericResponse<T> withResult(T result) {
		this.setResult(result);
		return this;
	}

	public GenericResponse<T> withStatus(Status status) {
		this.setStatus(status);
		return this;
	}

	public GenericResponse<T> withErrors(List<MessageResponse> errors) {
		this.setErrors(errors);
		return this;
	}

	public GenericResponse<T> withError(MessageResponse error) {
		this.setError(error);
		return this;
	}

	@Override
	public String toString() {
		return new StringBuilder("GenericResponse [").append("Status[").append(getStatus()).append("] result[")
				.append(", result=" + (result != null ? result.toString() : ""))
				.append("], error=" + (error != null ? error.toString() : ""))
				.append(", errors=" + (errors != null ? errors.toString() : "")).toString();
	}
}
