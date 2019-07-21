package com.wenthkim.esbase.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ES客户端
 */
@Configuration
public class EsClient {


    @Bean
    public RestHighLevelClient setEsClient() {
        return  new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.216.128", 9200, "http")));
    }


}
