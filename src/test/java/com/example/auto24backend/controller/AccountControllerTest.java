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

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegisterWrongParamAccount() {

        JSONObject body = new JSONObject();
        body.put("animal", "dog");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/register", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Wrong email", result.getBody());
    }

}