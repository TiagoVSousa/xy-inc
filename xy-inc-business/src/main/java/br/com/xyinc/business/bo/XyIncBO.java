package br.com.xyinc.business.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.xyinc.business.mapper.POIMap;
import br.com.xyinc.commons.dto.NearPOIRequestDTO;
import br.com.xyinc.commons.dto.POIDTO;
import br.com.xyinc.commons.exception.ArgumentsException;
import br.com.xyinc.commons.response.GenericResponse;
import br.com.xyinc.commons.response.MessageResponse;
import br.com.xyinc.commons.utils.MessageKeyEnum;
import br.com.xyinc.commons.utils.ValidaUtils;
import br.com.xyinc.repository.dao.XYRepository;

@Service
public class XyIncBO extends BOPadrao {

	private static final long serialVersionUID = 8276881218234280054L;
	private static final String COORDENADA_X = "Coordenada X";
	private static final String COORDENADA_Y = "Coordenada Y";

	@Autowired
	private XYRepository xyRepository;

	@Autowired
	private POIMap map;

	/**
	 * Retorna a listagem de pontos de interesse existentes.
	 * 
	 * @return lista de POIDTO
	 */
	public List<POIDTO> getAllPOI() {

		List<POIDTO> listDTO = map.convertMapToDTOList(xyRepository.findAll());
		Assert.notEmpty(listDTO, MessageKeyEnum.ERROR_POI_NOT_FOUND.toPropertyName());
		return listDTO;
	}

	/**
	 * Insere um novo ponto de interesse na base.
	 * 
	 * @param poiDTO
	 */
	private void insertPOI(POIDTO poiDTO) {

		validatePOI(poiDTO);
		xyRepository.save(map.mapToEntity(poiDTO));
	}

	@Transactional
	public void savePOIList(List<POIDTO> poiDTOList) {

		Assert.notEmpty(poiDTOList, MessageKeyEnum.REQUIRED_POI.toPropertyName());
		for (POIDTO poiDTO : poiDTOList) {
			insertPOI(poiDTO);
		}
	}

	/**
	 * Faz a busca de pontos de interesse proximos dentro do range de distancia
	 * definido com base na localizacao recebida.
	 * 
	 * @param dtoRequest
	 * @return lista de POIDTO
	 */
	public List<POIDTO> findNearPOI(NearPOIRequestDTO dtoRequest) {

		validateFindNearPOI(dtoRequest);
		List<POIDTO> poiDTOList = getAllPOI();

		List<POIDTO> nearPOIList = new ArrayList<POIDTO>();
		for (POIDTO poiDTO : poiDTOList) {
			if (Math.abs(poiDTO.getCoordX() - dtoRequest.getCoordX())
					+ Math.abs(poiDTO.getCoordY() - dtoRequest.getCoordY()) <= dtoRequest.getMaxDistance()) {
				nearPOIList.add(poiDTO);
			}
		}
		Assert.notEmpty(nearPOIList, MessageKeyEnum.ERROR_NOT_FOUND_NEAR_POI.toPropertyName());
		return nearPOIList;
	}

	/**
	 * Faz a validacao dos parametros recebidos na busca dos pontos de interesse
	 * proximos.
	 * 
	 * @param dto
	 */
	private void validateFindNearPOI(NearPOIRequestDTO dto) {

		GenericResponse<?> response = new GenericResponse<>();
		if (!ValidaUtils.isValidValue(dto.getCoordX())) {
			response.appendError(
					new MessageResponse(MessageKeyEnum.ERROR_INVALID_COORD.toPropertyName(), null, COORDENADA_X));
		}

		if (!ValidaUtils.isValidValue(dto.getCoordY())) {
			response.appendError(
					new MessageResponse(MessageKeyEnum.ERROR_INVALID_COORD.toPropertyName(), null, COORDENADA_Y));
		}

		if (!ValidaUtils.isValidValue(dto.getMaxDistance())) {
			response.appendError(new MessageResponse(MessageKeyEnum.ERROR_INVALID_MAXD.toPropertyName()));
		}

		if (!response.getErrors().isEmpty()) {
			throw new ArgumentsException(response);
		}
	}

	/**
	 * Faz a validacao dos pontos de interesse
	 * 
	 * @param dto
	 */
	private void validatePOI(POIDTO dto) {

		GenericResponse<POIDTO> response = new GenericResponse<>();
		Assert.notNull(dto, MessageKeyEnum.REQUIRED_POI.toPropertyName());
		if (StringUtils.isEmpty(dto.getName())) {
			response.appendError(new MessageResponse(MessageKeyEnum.REQUIRED_NM_POI.toPropertyName()));
		}

		if (!ValidaUtils.isValidValue(dto.getCoordX())) {
			response.appendError(new MessageResponse(MessageKeyEnum.ERROR_INVALID_COORD_POI.toPropertyName(), null,
					COORDENADA_X, dto.getName()));
		}

		if (!ValidaUtils.isValidValue(dto.getCoordY())) {
			response.appendError(new MessageResponse(MessageKeyEnum.ERROR_INVALID_COORD_POI.toPropertyName(), null,
					COORDENADA_Y, dto.getName()));
		}
		if (!response.getErrors().isEmpty()) {
			throw new ArgumentsException(response);
		}
	}
}
