package br.com.xyinc.commons.dto;

/**
 * Request DTO dos pontos de interesse proximos com getters setters e
 * construtores.
 * 
 * @author tiago
 *
 */

public class NearPOIRequestDTO {

	private Integer coordX;
	private Integer coordY;
	private Integer maxDistance;

	public NearPOIRequestDTO() {
	}

	public NearPOIRequestDTO(Integer maxDistance, Integer coordX, Integer coordY) {
		super();
		this.maxDistance = maxDistance;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Integer getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(Integer maxD) {
		this.maxDistance = maxD;
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
