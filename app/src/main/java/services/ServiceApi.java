package services;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ServiceApi {

    private final static String url = "http://192.168.16.100:8080/";

    public static String getService(String dataset, String method, String data) {
        String reqUrl;
        reqUrl = url + dataset;
        if (method == "GET") {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod(method);
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (Exception e) {
                Log.e("Service Api", "Exception: " + e.getMessage());
            }
            return response;
        } else if (method == "DELETE") {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod(method);
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (Exception e) {
                Log.e("Service Api", "Exception: " + e.getMessage());
            }
            return response;
        } else if (method == "POST") {
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestMethod(method);
                OutputStream out = conn.getOutputStream();
                byte[] input = data.getBytes("utf-8");
                out.write(input, 0, input.length);
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_CREATED)
                    return "OK";
                return "Erro";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (method == "PUT") {
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestMethod(method);
                OutputStream out = conn.getOutputStream();
                byte[] input = data.getBytes("utf-8");
                out.write(input, 0, input.length);
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_OK)
                    return "OK";
                return "Erro";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "";
    }


    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
