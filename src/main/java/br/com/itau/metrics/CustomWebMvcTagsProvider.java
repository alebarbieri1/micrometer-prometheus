package br.com.itau.metrics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.metrics.web.servlet.DefaultWebMvcTagsProvider;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;

public class CustomWebMvcTagsProvider extends DefaultWebMvcTagsProvider {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response, Object handler,
			Throwable exception) {
		logger.info("Custom tag provider");
		Tags tags = Tags.of(super.getTags(request, response, handler, exception));
		String apiKey = request.getHeader("x-itau-apikey");
		logger.info("Adding custom tag");
		tags = tags.and("channel", apiKey != null ? apiKey : "none");

		return tags;
	}

}
