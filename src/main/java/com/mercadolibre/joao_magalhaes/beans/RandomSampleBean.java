package com.mercadolibre.joao_magalhaes.beans;

import com.mercadolibre.joao_magalhaes.dtos.SampleDTO;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomSampleBean {
	private Random random = new Random();

	public SampleDTO random() {
		return new SampleDTO(random.nextInt(Integer.MAX_VALUE));
	}
}

