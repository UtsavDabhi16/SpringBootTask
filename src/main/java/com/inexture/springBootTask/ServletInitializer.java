package com.inexture.springBootTask;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
<<<<<<< HEAD
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
=======
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011
		return application.sources(SpringBootTaskApplication.class);
	}

}
