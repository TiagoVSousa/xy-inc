package br.com.xyinc.business.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.xyinc.commons.dto.POIDTO;
import br.com.xyinc.repository.entity.POI;

@Component
public class POIMap implements Serializable {

	private static final long serialVersionUID = 8497866046546289638L;

	/**
	 * Faz a conversao de map para POI
	 * 
	 * @param dto
	 * @return Poi
	 */
	public POI mapToEntity(POIDTO dto) {

		if (dto == null)
			return null;

		POI entity = new POI();
		entity.setNmPoi(dto.getName());
		entity.setNuX(dto.getCoordX());
		entity.setNuY(dto.getCoordY());
		return entity;
	}

	/**
	 * Faz a conversao de map para DTO
	 * 
	 * @param entity
	 * @return POIDTO
	 */
	public POIDTO convertMapToDTO(POI entity) {
		if (entity == null)
			return null;

		POIDTO poiDTO = new POIDTO();
		poiDTO.setName(entity.getNmPoi());
		poiDTO.setCoordX(entity.getNuX());
		poiDTO.setCoordY(entity.getNuY());
		return poiDTO;
	}

	/**
	 * Faz a conversao de map para lista de DTO
	 * 
	 * @param entityList
	 * @return lista de POIDTO
	 */
	public List<POIDTO> convertMapToDTOList(List<POI> entityList) {
		if (entityList == null) {
			return Collections.emptyList();
		}

		List<POIDTO> list = new ArrayList<>();
		for (POI entity : entityList) {
			list.add(convertMapToDTO(entity));
		}

		return list;
	}

}
