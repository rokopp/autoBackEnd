package com.example.auto24backend.controller;

import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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


    @Test
    public void testAdvertisementUploadWithoutFile() {

        JSONObject body = new JSONObject();
        body.put("userName", "Bob");
        body.put("password", "Bob1234");
        body.put("email", "Bob@Bob.Bob");
        body.put("phoneNumber", "5628179");

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/register", request, String.class);

        JSONObject carMark = new JSONObject();
        carMark.put("carMark", "Bmw");

        JSONObject adJson = new JSONObject();
        adJson.put("description", "Mega pill");
        adJson.put("serialNr", "555ooo");
        adJson.put("price", "15799");
        adJson.put("carMark", carMark);

        JSONObject ad = new JSONObject();
        ad.put("userName", "Bob");
        ad.put("ad", adJson);
        ad.put("file", null);

        System.out.println(ad);

        HttpEntity<String> requestAd = new HttpEntity<>(ad.toString(), headers);

        ResponseEntity<String> resultAd = this.restTemplate.postForEntity("/api/ads", requestAd, String.class);

        Assert.assertEquals(400, resultAd.getStatusCodeValue());
        Assert.assertEquals("Wrong email", resultAd.getBody());
    }
}
