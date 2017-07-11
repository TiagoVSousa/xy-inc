package br.com.xyinc.commons.response;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import br.com.xyinc.commons.utils.MessageUtils;

/**
 * Classe que contem o Message Response.
 * 
 * @author tiago
 *
 */

public class MessageResponse implements Serializable {

	private static final long serialVersionUID = -1801361260333443239L;

	private String key;
	private String message;

	public MessageResponse() {
	}

	public MessageResponse(String key) {
		this.key = key;
		this.message = String.format(MessageUtils.getMessage(key));
	}

	public MessageResponse(String key, String message, Object... params) {
		this.key = key;
		if (StringUtils.isEmpty(message)) {
			this.message = String.format(MessageUtils.getMessage(key), params);
		} else {
			this.message = message;
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
