package br.com.xyinc.commons.dto;

import br.com.xyinc.commons.dto.POIDTO;

/**
 * Request DTO dos pontos de interesse com getters setters e construtores.
 * 
 * @author tiago
 *
 */
public class POIDTO {

	private Integer coordX;
	private Integer coordY;
	private String name;

	public POIDTO() {
	}

	public POIDTO(String name, Integer coordX, Integer coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCoordX() {
		return coordX;
	}

	public void setCoordX(Integer coordX) {
		this.coordX = coordX;
	}

	public Integer getCoordY() {
		return coordY;
	}

	public void setCoordY(Integer coordY) {
		this.coordY = coordY;
	}
}
