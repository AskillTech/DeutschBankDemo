package com.db.demo.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainApplicationProperties {

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.version}")
    private String applicationVersion;

	public String getApplicationName() {
		return applicationName;
	}

	public Object getApplicationVersion() {
		return applicationVersion;
	}

}
