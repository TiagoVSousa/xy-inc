package br.com.xyinc.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Pontos de interesse
 * 
 * @author tiago
 *
 */

@Entity
@Table(name = "tb_xy_poi")
public class POI implements Serializable {

	private static final long serialVersionUID = -4424254569172316070L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nm_poi")
	private String nmPoi;

	@Column(name = "nu_x")
	private Integer nuX;

	@Column(name = "nu_y")
	private Integer nuY;

	public POI(String nmPoi, Integer nuX, Integer nuY) {
		this.nmPoi = nmPoi;
		this.nuX = nuX;
		this.nuY = nuY;
	}

	public POI() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNmPoi() {
		return nmPoi;
	}

	public void setNmPoi(String nmPoi) {
		this.nmPoi = nmPoi;
	}

	public Integer getNuX() {
		return nuX;
	}

	public void setNuX(Integer nuX) {
		this.nuX = nuX;
	}

	public Integer getNuY() {
		return nuY;
	}

	public void setNuY(Integer nuY) {
		this.nuY = nuY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nmPoi == null) ? 0 : nmPoi.hashCode());
		result = prime * result + ((nuX == null) ? 0 : nuX.hashCode());
		result = prime * result + ((nuY == null) ? 0 : nuY.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POI other = (POI) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nmPoi == null) {
			if (other.nmPoi != null)
				return false;
		} else if (!nmPoi.equals(other.nmPoi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poi [id=" + id + ", nmPoi=" + nmPoi + ", nuX=" + nuX + ", nuY=" + nuY + "]";
	}

}
