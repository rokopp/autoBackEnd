package com.example.auto24backend.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdvertisementControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAdvertisements() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/api/ads", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testSearchByPrice() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/api/ads/search?start100&stop=200", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }

}