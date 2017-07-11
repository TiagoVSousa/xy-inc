package br.com.xyinc.business.bo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.xyinc.business.mapper.POIMap;
import br.com.xyinc.commons.dto.POIDTO;
import br.com.xyinc.repository.dao.XYRepository;
import br.com.xyinc.repository.entity.POI;

/**
 * Classe de teste do modulo de Business com implementacao dos metodos.
 * 
 * @author tiago
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class XyIncBOTest extends InitTest {

	@InjectMocks
	private XyIncBO poiBO;

	@Mock
	private XYRepository poiDAO;

	@Spy
	private POIMap poiMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSuccessFindAllPoi() {

		when(poiDAO.findAll()).thenReturn(getSamplePoiList());
		List<POIDTO> resultList = poiBO.getAllPOI();

		assertThat(resultList).isNotNull();
		assertThat(resultList).isNotEmpty();
		assertThat(resultList.size()).isEqualTo(4);
	}

	@Test
	public void shouldErrorFindAllPoi() {

		when(poiDAO.findAll()).thenReturn(new ArrayList<>());
		String message = StringUtils.EMPTY;
		try {
			poiBO.getAllPOI();
		} catch (Exception e) {
			message = e.getMessage();
		}
		assertThat(message).isNotNull();
		assertThat(message).isEqualTo("error.poi.not.found");
	}

	private List<POI> getSamplePoiList() {

		List<POI> resultList = new ArrayList<>();
		POI poi1 = createRandomPoi();
		POI poi2 = createRandomPoi();
		POI poi3 = createRandomPoi();
		POI poi4 = createRandomPoi();

		resultList.add(poi1);
		resultList.add(poi2);
		resultList.add(poi3);
		resultList.add(poi4);
		return resultList;
	}

	private POI createRandomPoi() {
		return new POI(buildRandomString(), buildRandomNumber(), buildRandomNumber());
	}

}
