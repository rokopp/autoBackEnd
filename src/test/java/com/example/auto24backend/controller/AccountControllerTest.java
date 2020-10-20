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

    @Test
    public void testRegisterDoubleAccount() {

        JSONObject body = new JSONObject();
        body.put("userName", "Bob");
        body.put("password", "Bob1234");
        body.put("email", "Bob@Bob.Bob");
        body.put("phoneNumber", "5628179");

        System.out.println(body);

        JSONObject body2 = new JSONObject();
        body2.put("userName", "Bob");
        body2.put("password", "Bob1234");
        body2.put("email", "Bob@Bob.Bob");
        body2.put("phoneNumber", "5628179");


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);
        HttpEntity<String> request2 = new HttpEntity<>(body2.toString(), headers);

        this.restTemplate.postForEntity("/api/register", request, String.class);
        ResponseEntity<String> result2 = this.restTemplate.postForEntity("/api/register", request2, String.class);

        Assert.assertEquals(200, result2.getStatusCodeValue());
        Assert.assertEquals("An account already exists with this name and/or e-mail. Please try again.", result2.getBody());
    }

}
