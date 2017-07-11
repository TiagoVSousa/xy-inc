package br.com.xyinc.ws;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Matchers.any;

import br.com.xyinc.business.bo.XyIncBO;
import br.com.xyinc.commons.dto.NearPOIRequestDTO;
import br.com.xyinc.commons.dto.POIDTO;
import br.com.xyinc.commons.response.Status;
import br.com.xyinc.ws.controller.XyIncController;


/**
 * Classe de testes do modulo WS.
 * 
 * @author tiago
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class XyIncControllerTest extends ControllerTestConfig {

	private MockMvc mockMvc;

	@InjectMocks
	private XyIncController xyIncController;

	@Mock
	private XyIncBO xyIncBO;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(xyIncController).build();
	}

	@Test
	public void shouldSuccessGetFindAll() throws Exception {

		when(xyIncBO.getAllPOI()).thenReturn(getSamplePoiList());

		mockMvc.perform(get("/xyinc/pois").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.result").isArray())
				.andExpect(jsonPath("$.status", equalTo(Status.SUCCESS.name())));
	}

	private List<POIDTO> getSamplePoiList() {

		List<POIDTO> resultList = new ArrayList<>();
		POIDTO poi1 = createRandomPoi();
		POIDTO poi2 = createRandomPoi();
		POIDTO poi3 = createRandomPoi();
		POIDTO poi4 = createRandomPoi();

		resultList.add(poi1);
		resultList.add(poi2);
		resultList.add(poi3);
		resultList.add(poi4);
		return resultList;
	}

	private POIDTO createRandomPoi() {
		return new POIDTO(buildRandomString(), buildRandomNumber(), buildRandomNumber());
	}
	
	@Test
	public void testNearPOI() throws Exception{
		when(xyIncBO.findNearPOI(any(NearPOIRequestDTO.class))).thenReturn(new ArrayList<>());
		
		mockMvc.perform(post("/xyinc/pois/prox")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(toJson(new NearPOIRequestDTO())))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.result").isArray())
		.andExpect(jsonPath("$.result", equalTo(Collections.EMPTY_LIST)))
		.andExpect(jsonPath("$.status", equalTo(Status.SUCCESS.name())));
	}
}
