package br.com.itau.metrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsApplication.class, args);
	}

	@SuppressWarnings("rawtypes")
	@Bean
	MeterRegistryCustomizer meterRegistryCustomizer(@Value("${spring.application.name}") String appName) {
		return registry -> registry.config().commonTags("app", appName);
	}

	@Bean
	public WebMvcTagsProvider webMvcTagsProvider() {
		return new CustomWebMvcTagsProvider();
	}

}