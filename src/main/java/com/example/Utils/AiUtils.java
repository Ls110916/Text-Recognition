package com.example.Utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {
    public static final String APP_ID = "";
    public static final String API_KEY = "";
    public static final String SECRET_KEY = "";

    public static String picToWords(MultipartFile file) throws IOException {
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        // 调用接口
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray words_result = res.getJSONArray("words_result");

        String result = "";

        for (int i = 0; i < words_result.length(); i++) {
            JSONObject jsonObject = words_result.getJSONObject(i);
            String words = (String) jsonObject.get("words");
            result += words + " ";
            System.out.println(words);
        }
        return result;
    }

}
