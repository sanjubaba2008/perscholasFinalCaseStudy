package com.ayurveda.caseStudy.services;


import com.ayurveda.caseStudy.models.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ConsumeQuote {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
                .setConnectTimeout(Duration.ofSeconds(3))
                .setReadTimeout(Duration.ofSeconds(3))
                .build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            List<Quote> quoteList = new ArrayList<>();

            for(int x = 0; x<13; x++) {
                Quote quote = restTemplate.getForObject(
                        "https://quoters.apps.pcfone.io/api/random", Quote.class);
                quoteList.add(quote);
                log.warn(quote.toString());
            }
            quoteList.forEach(quote -> System.out.println(quote.getValue().getQuote()));
        };
    }
}
