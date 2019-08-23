package com.example.demo.integrations.fides;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;

import com.example.demo.integrations.fides.models.criterions.LoginCriteria;
import com.example.demo.integrations.fides.models.viewmodels.LoginResponse;

public class FidesClient
{
    private String url;
    private CloseableHttpClient httpClient;
    private String username;
    private String password;
    private String sessionId;

    public FidesClient(Boolean isTest)
    {
        System.out.println("Constructing FIDES client");
        httpClient = HttpClients.createDefault();
        if (isTest)
        {
            this.url = "https://dev.fidescloud.co.za/FidesREST/";
            this.username = "7701145032088";
            this.password = "7701145032088";
        }
        else
        {
            this.url = "https://services-2.fidescloud.co.za/FidesREST/";
            this.username = "7701145032088";
            this.password = "7701145032088";
        }
    }

    public String getSessionId()
    {
        return this.sessionId;
    }

    public void login() throws Exception
    {
        var url = new URL(this.url + "session/login/" + this.username);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");

        var loginCriteria = new LoginCriteria(this.password, "Tyme", true);
        var stringContent = new Gson().toJson(loginCriteria);
        byte[] inputBytes = stringContent.getBytes(StandardCharsets.UTF_8);
        httpURLConnection.setFixedLengthStreamingMode((inputBytes.length));
        httpURLConnection.connect();
        try(var outputStream = httpURLConnection.getOutputStream())
        {
            System.out.println(outputStream.toString());
            byte[] b = new byte[0];
            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream)outputStream;
            var outBytes = byteArrayOutputStream.toByteArray();
            String outputJsonString = new String(outBytes);
            var response = new Gson().fromJson(outputJsonString, LoginResponse.class);

            this.sessionId = response.SessionId;
        }
    }

    private void clearSessionId()
    {
        this.sessionId = "";
    }
}
