package com.example.auto24backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarMarkControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    public String getAdminToken() throws JsonProcessingException {
        Map<String, String> user = new HashMap<>();
        user.put("username", "aaa");
        user.put("password", "aaa");

        this.restTemplate.getForEntity("/api/login?username={username}&password={password}", String.class, user);
        ResponseEntity<String> result2 = this.restTemplate.getForEntity
                ("/api/login?username={username}&password={password}", String.class, user);
        JSONObject jsonString = new ObjectMapper().readValue(result2.getBody(), JSONObject.class);
        return (jsonString.getAsString("token"));
    }

    @Test
    public void getCarMarksZero() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/api/carMarks", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void saveCarMark() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("carMark", "BMW");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAdminToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/admin/carMarks", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Successfully added", result.getBody());
    }

    @Test
    public void saveCarMarkThatExists() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("carMark", "VW");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAdminToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        this.restTemplate.postForEntity("/api/admin/carMarks", request, String.class);
        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/admin/carMarks", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Car mark already present", result.getBody());
    }

    @Test
    public void saveCarMarkNothing() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("carMark", "");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAdminToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/admin/carMarks", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Please insert car mark", result.getBody());
    }

    @Test
    public void saveCarMarkNull() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("carMark", null);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getAdminToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/admin/carMarks", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Wrong car mark", result.getBody());
    }
}
