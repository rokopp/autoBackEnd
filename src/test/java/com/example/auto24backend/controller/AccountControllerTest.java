package com.example.auto24backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    public String getToken() throws JsonProcessingException {
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
    public void testRegisterWrongParamAccount() {

        JSONObject body = new JSONObject();
        body.put("animal", "dog");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/register", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Error in input", result.getBody());
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
        Assert.assertEquals("Account already exists", result2.getBody());
    }

    @Test
    public void testAdminRegisterWithoutToken() {
        JSONObject body = new JSONObject();
        body.put("userName", "Bob");
        body.put("password", "Bob1234");
        body.put("email", "Bob@Bob.Bob");
        body.put("phoneNumber", "5628179");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        this.restTemplate.postForEntity("/api/admin/registerAdmin", request, String.class);
        ResponseEntity<String> result2 = this.restTemplate.postForEntity("/api/admin/registerAdmin", request, String.class);

        Assert.assertEquals(403, result2.getStatusCodeValue());
        Assert.assertNull(result2.getBody());
    }

    @Test
    public void loginAsAdmin() throws JsonProcessingException {

        Map<String, String> user = new HashMap<>();
        user.put("username", "aaa");
        user.put("password", "aaa");

        this.restTemplate.getForEntity("/api/login?username={username}&password={password}", String.class, user);
        ResponseEntity<String> result2 = this.restTemplate.getForEntity
                ("/api/login?username={username}&password={password}", String.class, user);

        Assert.assertEquals(200, result2.getStatusCodeValue());
    }

    @Test
    public void testRegisterUser() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("userName", "MinaSiin");
        body.put("password", "MinaSiin");
        body.put("email", "MinaSiin@Bob.Bob");
        body.put("phoneNumber", "5628179");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity("/api/register", request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Registered",result.getBody());
    }

    @Test
    public void testAdminRegisterWithToken() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("userName", "MinaSiinAdmin");
        body.put("password", "MinaSiinAdmin");
        body.put("email", "MinaSiinAdmin@Bob.Bob");
        body.put("phoneNumber", "5628179");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result2 = this.restTemplate.postForEntity("/api/admin/registerAdmin", request, String.class);

        Assert.assertEquals(200, result2.getStatusCodeValue());
        Assert.assertEquals("Registered",result2.getBody());
    }

    @Test
    public void testAdminDoubleRegisterWithToken() throws JsonProcessingException {
        JSONObject body = new JSONObject();
        body.put("userName", "BobSiinAdmin");
        body.put("password", "BobSiinAdmin");
        body.put("email", "BobSiinAdmin@Bob.Bob");
        body.put("phoneNumber", "5628179");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request2 = new HttpEntity<>(body.toString(), headers);

        this.restTemplate.postForEntity("/api/admin/registerAdmin", request2, String.class);
        ResponseEntity<String> result2 = this.restTemplate.postForEntity("/api/admin/registerAdmin", request2, String.class);

        Assert.assertEquals(200, result2.getStatusCodeValue());
        Assert.assertEquals("Account already exists",result2.getBody());
    }
}
