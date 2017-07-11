package br.com.xyinc.commons.utils;

/**
 * Enum que contem as keys das mensagens existentes.
 * 
 * @author tiago
 *
 */

public enum MessageKeyEnum {

	REQUIRED_POI, REQUIRED_NM_POI, REQUIRED_X_POI, REQUIRED_Y_POI, ERROR_POI_NOT_FOUND, SUCCESS, SUCCESS_FIND_POI, SUCCESS_SAVE_POI, ERROR_NOT_FOUND_NEAR_POI, ERROR_UNEXPECTED, ERROR_INVALID_COORD, ERROR_INVALID_COORD_POI, ERROR_INVALID_MAXD;

	public String toPropertyName() {

		return this.name().toLowerCase().replace('_', '.');
	}

}
