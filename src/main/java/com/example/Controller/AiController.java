package com.example.Controller;

import com.example.Utils.AiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AiController {

    @RequestMapping(value = "/pic", method = RequestMethod.POST)
    public String APicTowords(@RequestParam("file")MultipartFile file) throws IOException {
        String s = AiUtils.picToWords(file);
        return s;
    }
}
