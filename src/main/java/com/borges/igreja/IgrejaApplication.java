package com.borges.igreja;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class IgrejaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgrejaApplication.class, args);
	}
	
	 @Bean
	    public LocaleResolver localeResolver(){
	        return new FixedLocaleResolver(new Locale("pt", "BR"));
	    }
	 
	 //Configura maxPostSize do servidor tomcat incorporado para 3 megabytes (o padrão é 2 MB, não é grande o suficiente para suportar uploads de arquivos> 1,5 MB)
	 @Bean
	 EmbeddedServletContainerCustomizer containerCustomizer() throws Exception {
	     return (ConfigurableEmbeddedServletContainer container) -> {
	         if (container instanceof TomcatEmbeddedServletContainerFactory) {
	             TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
	             tomcat.addConnectorCustomizers(
	                 (connector) -> {
	                     connector.setMaxPostSize(3000000); // 3 MB
	                 }
	             );
	         }
	     };
	 }
}

