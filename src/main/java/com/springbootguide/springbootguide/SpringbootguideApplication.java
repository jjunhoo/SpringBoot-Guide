package com.springbootguide.springbootguide;

import com.springbootguide.springbootguide.comsuming_restful_web_service.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootguideApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringbootguideApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootguideApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        System.out.println("[resttemaplte !]");
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        System.out.println("[run!] : " + restTemplate);
        return args -> {
            Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
