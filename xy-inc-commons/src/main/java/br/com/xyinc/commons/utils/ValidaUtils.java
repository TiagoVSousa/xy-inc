package br.com.xyinc.commons.utils;

/**
 * Verifica se o valor recebido e valido.
 * @author tiago
 *
 */

public class ValidaUtils {

	private ValidaUtils() {
	}
	
	/**
	 * Verifica se os valores recebidos sao validos.
	 * @param value
	 * @return boolean
	 */
	public static boolean isValidValue(Integer value){
		if(value == null) return false;
		return value > 0;
	}
}
