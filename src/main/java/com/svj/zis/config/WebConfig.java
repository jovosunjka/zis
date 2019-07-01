package com.svj.zis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MarshallingHttpMessageConverter marshallingHttpMessageConverter;

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // https://www.baeldung.com/spring-httpmessageconverter-rest
        converters.add(marshallingHttpMessageConverter);
        converters.add(mappingJackson2HttpMessageConverter);
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD");
    }

    //@CrossOrigin(origins = "http://domain2.com")
    //moguce je i ovu anotaciju koristiti za cors support
    // ova anotacija se stavlja iznad controller-a ili metoda controller-a

}