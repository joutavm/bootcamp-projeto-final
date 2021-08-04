package com.mercadolibre.joao_magalhaes.unit.beans;

import com.mercadolibre.joao_magalhaes.dtos.SampleDTO;
import com.mercadolibre.joao_magalhaes.beans.RandomSampleBean;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomSampleBeanTest {

	@Test
	public void randomPositiveTestOK() {
		RandomSampleBean randomSample = new RandomSampleBean();

		SampleDTO sample = randomSample.random();
		
		assertTrue(sample.getRandom() >= 0);
	}
}
