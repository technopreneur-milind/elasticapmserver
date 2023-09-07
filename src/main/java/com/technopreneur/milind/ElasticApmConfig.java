package com.technopreneur.milind;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import co.elastic.apm.attach.ElasticApmAttacher;
import jakarta.annotation.PostConstruct;

@Configuration
public class ElasticApmConfig {
	
	private static final String SERVER_URL_KEY = "server_url";
    private String serverUrl="https://7aa0432ff5d84eb6a6f8210479f599f8.apm.ap-south-1.aws.elastic-cloud.com:443";

    private static final String SERVICE_NAME_KEY = "service_name";
    private String serviceName="elasticapmserver";

    private static final String SECRET_TOKEN_KEY = "secret_token";
    private String secretToken="nFb9ARAhlzRhm9cL5O";

    private static final String ENVIRONMENT_KEY = "environment";
    private String environment="dev";

    @PostConstruct
    public void init() {

        Map<String, String> apmProps = new HashMap<>(6);
        apmProps.put(SERVER_URL_KEY, serverUrl);
        apmProps.put(SERVICE_NAME_KEY, serviceName);
        apmProps.put(SECRET_TOKEN_KEY, secretToken);
        apmProps.put(ENVIRONMENT_KEY, environment);
       

        ElasticApmAttacher.attach(apmProps);
    }

}
