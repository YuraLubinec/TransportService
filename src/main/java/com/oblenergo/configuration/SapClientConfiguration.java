package com.oblenergo.configuration;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.oblenergo.wsClient.SapClient;
import com.sap.document.sap.soap.functions.mc_style.ObjectFactory;


@Configuration
@PropertySource("classpath:sapclient.properties")
public class SapClientConfiguration {

  @Autowired
  Environment environment;

  @Bean
  public Jaxb2Marshaller marshaller() {

    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan("com.sap.document.sap.soap.functions.mc_style");
    return marshaller;
  }

  @Bean
  public SapClient sapClient(Jaxb2Marshaller marshaller, HttpComponentsMessageSender componentsMessageSender) {

    SapClient client = new SapClient(); 
    client.getWebServiceTemplate().setMessageSender(componentsMessageSender);
    client.setDefaultUri(environment.getRequiredProperty("sap.service.default.uri"));
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
   
    return client;
  }
  
  @Bean 
  public SaajSoapMessageFactory saajSoapMessageFactory(){

    return new SaajSoapMessageFactory();
  }

  @Bean
  public HttpComponentsMessageSender httpComponentsMessageSender(UsernamePasswordCredentials credentials) {

    HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
    messageSender.setCredentials(credentials);
    return messageSender;
  }

  @Bean
  public UsernamePasswordCredentials usernamePasswordCredentials() {

    return new UsernamePasswordCredentials(environment.getRequiredProperty("sap.user.name"),
        environment.getRequiredProperty("sap.user.password"));
  }

  @Bean
  public ObjectFactory objectFactory() {

    return new ObjectFactory();
  }
}
