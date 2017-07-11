package br.com.xyinc.ws;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.test.context.ContextConfiguration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.xyinc.business.config.XYBusinessConfig;

/**
 * Classe de configuracao de testes do modulo WS.
 * 
 * @author tiago
 *
 */

@ContextConfiguration(classes = XYBusinessConfig.class)
public abstract class ControllerTestConfig {

	private final Gson gson = new Gson();
	protected Random random = new Random();

	/**
	 * Converte de Object para Json
	 * 
	 * @param src
	 * @return String
	 */
	protected String toJson(Object src) {
		return gson.toJson(src);
	}

	/**
	 * Converte de Json para um GenericType.
	 * 
	 * @param json
	 * @param list
	 * @return GenericType <T>
	 * @throws Exception
	 */
	protected <T> T fromJson(String json, List<T> list) throws Exception {
		Type listType = new TypeToken<ArrayList<T>>() {
		}.getType();
		return gson.fromJson(json, listType);
	}

	protected <T> T fromJson(String json, Class<T> classOfT) throws Exception {
		return gson.fromJson(json, (Type) classOfT);
	}

	/**
	 * Gera um numero aleatorio.
	 * 
	 * @return Integer
	 */
	protected Integer buildRandomNumber() {
		return random.nextInt(2);
	}

	/**
	 * Gera um numero negativo aleatorio.
	 * 
	 * @return Integer
	 */
	protected Integer buildRandomNegativeNumber() {
		return random.nextInt(-2);
	}

	/**
	 * Gera uma String aleatoria.
	 * 
	 * @return String
	 */
	protected String buildRandomString() {
		return RandomStringUtils.randomAlphabetic(15);
	}
}
