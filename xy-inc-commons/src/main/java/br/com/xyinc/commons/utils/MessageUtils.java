package br.com.xyinc.commons.utils;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * Faz uma busca nas propriedades pela key da mensagem
 *
 */
@Component
@Scope("singleton")
public final class MessageUtils {

	private static final Logger logger = LoggerFactory.getLogger(MessageUtils.class);

	private MessageUtils() {

	}

	public static String getMessage(String key, Object... params) {
		ResourceBundleMessageSource bean = new ResourceBundleMessageSource();
		try {
			bean.setBasename("messages/messages");
			return bean.getMessage(key, params, Locale.getDefault());
		} catch (Exception e) {
			logger.warn("Failed get message", e);
			return bean.getMessage("error.unexpected", null, Locale.getDefault());
		}

	}
}
