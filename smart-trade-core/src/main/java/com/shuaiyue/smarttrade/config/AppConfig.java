package com.shuaiyue.smarttrade.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:META-INF/properties/app.properties")
public class AppConfig {

	@Value("${app.name}")
	String appName;
	
	@Bean
	public String appName() {
		return this.appName;
	}
	
	@Bean
	// This bean performs the prop place holder replacement
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setIgnoreUnresolvablePlaceholders( true );
		return pspc;
	}
	
    @PropertySource("classpath:META-INF/properties/local.properties")
    @Configuration
    @Profile({
        "local"
    })
    public static class LocalConfig {
    }

//    @PropertySource("classpath:META-INF/properties/qa.properties")
//    @Configuration
//    @Profile({
//        "qa"
//    })
//    public static class QaConfig {
//    }
//
//    @PropertySource("classpath:META-INF/properties/prod.properties")
//    @Configuration
//    @Profile({
//        "prod"
//    })
//    public static class ProdConfig {
//    }

//  @Bean
//  public PoolingHttpClientConnectionManager poolingClientConnectionManager() {
//      PoolingHttpClientConnectionManager conman = new PoolingHttpClientConnectionManager();
//      conman.setMaxTotal( 500 );
//      conman.setDefaultMaxPerRoute( 50 );
//      return conman;
//  }
//
//  @Bean
//  public HttpClient httpClient() {
//      HttpClientBuilder builder = HttpClients.custom().setConnectionManager( this.poolingClientConnectionManager() );
//      Properties props = System.getProperties();
//      if ( props.containsKey( "http.proxyHost" ) && props.containsKey( "http.proxyPort" ) ) {
//          builder.setProxy( new HttpHost( props.getProperty( "http.proxyHost" ), Integer.valueOf( props.getProperty( "http.proxyPort" ) ) ) );
//      }
//      return builder.build();
//  }

}

