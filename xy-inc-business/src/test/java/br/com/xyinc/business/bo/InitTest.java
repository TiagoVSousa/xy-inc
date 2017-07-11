package br.com.xyinc.business.bo;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import br.com.xyinc.business.config.XYBusinessConfig;

/**
 * Classe de configuracao de testes do modulo Business.
 * 
 * @author tiago
 *
 */

@ContextConfiguration(classes = XYBusinessConfig.class)
public class InitTest {

	protected Random random = new Random();

	protected Integer buildRandomNumber() {
		return random.nextInt(2);
	}

	protected Integer buildRandomNegativeNumber() {
		return random.nextInt(-2);
	}

	protected String buildRandomString() {
		return RandomStringUtils.randomAlphabetic(15);
	}

	@Test
	public void test() {
		Assert.assertTrue(true);
	}
}
