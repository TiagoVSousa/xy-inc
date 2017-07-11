package br.com.xyinc.ws.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.xyinc.business.bo.XyIncBO;

import br.com.xyinc.commons.dto.DataPOIDTO;
import br.com.xyinc.commons.dto.NearPOIRequestDTO;
import br.com.xyinc.commons.dto.POIDTO;
import br.com.xyinc.commons.response.GenericResponse;
import br.com.xyinc.commons.response.Status;
import br.com.xyinc.ws.util.MediaType;

/**
 * XyIncController.
 * 
 * @author tiago
 *
 */

@RestController
@RequestMapping("/xyinc")
public class XyIncController {

	@Autowired
	private XyIncBO poiBO;

	/**
	 * Servico que lista todos os pontos de interesse atualmente cadastrados na base
	 * de dados.
	 * 
	 * @return @GenericResponse
	 */
	@RequestMapping(value = "/pois", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8)
	public GenericResponse<List<POIDTO>> getAllPoi() {

		return new GenericResponse<>(poiBO.getAllPOI()).withStatus(Status.SUCCESS);
	}

	/**
	 * Servico que adiciona novos pontos de interesse.
	 * 
	 * @param poiDTO
	 * @return @GenericResponse
	 */
	@RequestMapping(value = "/pois", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8)
	public GenericResponse<?> insertPoi(@NotNull @RequestBody DataPOIDTO poiDTO) {

		poiBO.savePOIList(poiDTO.getPoiList());
		return new GenericResponse<>().withStatus(Status.SUCCESS);
	}

	/**
	 * Servico que busca pontos de interesse em uma area proxima.
	 * 
	 * @param request
	 * @return @GenericResponse
	 */
	@RequestMapping(value = "/pois/prox", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8)
	public GenericResponse<List<POIDTO>> getNearPoi(@NotNull @RequestBody NearPOIRequestDTO request) {

		return new GenericResponse<>(poiBO.findNearPOI(request)).withStatus(Status.SUCCESS);
	}
}
