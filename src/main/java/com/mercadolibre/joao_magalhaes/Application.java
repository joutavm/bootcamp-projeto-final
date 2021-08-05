package com.mercadolibre.joao_magalhaes;

import com.mercadolibre.joao_magalhaes.application.config.SpringConfig;
import com.mercadolibre.joao_magalhaes.application.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ScopeUtils.calculateScopeSuffix();
		new SpringApplicationBuilder(SpringConfig.class).registerShutdownHook(true)
				.run(args);
	}
}