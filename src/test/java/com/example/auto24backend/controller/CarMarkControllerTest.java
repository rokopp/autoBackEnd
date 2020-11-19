package com.example.auto24backend.controller;

import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarMarkControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCarMarksZero() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/api/carMarks", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Disabled
    @Test
    public void saveCarMark() {
        JSONObject body = new JSONObject();
        body.put("carMark", "BMW");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/carMarks", request, String.class);

        Assert.assertEquals(500, result.getStatusCodeValue());
        Assert.assertEquals("Wrong email", result.getBody());
    }
}
