package br.com.itau.metrics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

	@GetMapping("/v1/metrics")
	private ResponseEntity<String> metricsV1() {
		return ResponseEntity.ok("Metrics v1");
	}

	@GetMapping("/v2/metrics")
	private ResponseEntity<String> metricsV2() {
		return ResponseEntity.ok("Metrics v2");
	}

	@GetMapping("/v3/metrics")
	private ResponseEntity<String> metricsV3() {
		return ResponseEntity.ok("Metrics v3");
	}

}