package com.ruby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by ShdwBt on 24/09/2017.
 */
@Controller
public class UploadedFileController {
    @RequestMapping(value="/singleUpload")
    public String singleUpload(){
        return "singleUpload";
    }

    @RequestMapping(value="/singleSave", method= RequestMethod.POST )
    public @ResponseBody
    String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc ){

        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:/test/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();

                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }
}
