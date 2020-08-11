package com.tn.scrms.controller.hehe;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: yangcs
 * @Date: 2020/7/22 8:30
 * @Description:
 */
public class HeHeController {

    public static void main(String[] args) throws Exception {

        String url = "https://ocr-api.ccint.com/cci_ai/service/v1/text_recog_ch_en";
        String appKey = "8d4f3eabaf7d24132ee34b68d8315741"; // your app_key
        String appSecret = "27383c46fea826d74975ca96193d65b5"; // your app_secret
        BufferedReader in = null;
        DataOutputStream out = null;
        String result = "";
        try {
            byte[] imgData = readfile("src\\main\\resources\\vis\\12.png"); // image
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("app-key", appKey);
            conn.setRequestProperty("app-secret", appSecret);
            conn.setRequestProperty("service", "text_recog_ch_en");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // 设置请求方式
            out = new DataOutputStream(conn.getOutputStream());
            out.write(imgData);
            out.flush();
            out.close();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(result);
    }

    public static byte[] readfile(String path) {
        String imgFile = path;
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
