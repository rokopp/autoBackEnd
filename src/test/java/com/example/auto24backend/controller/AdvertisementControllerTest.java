package com.example.auto24backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdvertisementControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    public void setUp() {
        JSONObject body = new JSONObject();
        body.put("userName", "Mina");
        body.put("password", "Mina");
        body.put("email", "Mina@Bob.Bob");
        body.put("phoneNumber", "5628179");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        this.restTemplate.postForEntity("/api/register", request, String.class);
    }

    public String getUserToken() throws JsonProcessingException {
        setUp();
        Map<String, String> user = new HashMap<>();
        user.put("username", "Mina");
        user.put("password", "Mina");

        this.restTemplate.getForEntity("/api/login?username={username}&password={password}", String.class, user);
        ResponseEntity<String> result2 = this.restTemplate.getForEntity
                ("/api/login?username={username}&password={password}", String.class, user);

        JSONObject jsonString = new ObjectMapper().readValue(result2.getBody(), JSONObject.class);
        return (jsonString.getAsString("token"));
    }

    @Test
    public void getAdvertisements() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/api/ads", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testSearchByPrice() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/api/ads/search?start=100&stop=200", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testSearchByCarMark() {
        JSONObject carMark = new JSONObject();
        carMark.put("id", 1);
        carMark.put("carMark", "Audi");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(carMark.toString(), headers);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("/api/ads/search",
                request, String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }


    @Disabled
    @Test
    public void testAdvertisementUploadWithoutFile() throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getUserToken());
        headers.add("Content-Type","multipart/form-data");

        JSONObject carMark = new JSONObject();
        carMark.put("carMark", 1);

        JSONObject adJson = new JSONObject();
        adJson.put("description", "Mega pill");
        adJson.put("serialNr", "555ooo");
        adJson.put("price", "15799");
        adJson.put("carMark", carMark);

        JSONObject ad = new JSONObject();
        ad.put("username", "Bob");
        ad.put("ad", adJson);
        ad.put("file", null);

        System.out.println(ad);

        HttpEntity<String> requestAd = new HttpEntity<>(ad.toString(), headers);

        ResponseEntity<String> resultAd = this.restTemplate.postForEntity("/api/user/ads", requestAd, String.class);

        Assert.assertEquals(400, resultAd.getStatusCodeValue());
        Assert.assertEquals("Wrong email", resultAd.getBody());
    }
}
