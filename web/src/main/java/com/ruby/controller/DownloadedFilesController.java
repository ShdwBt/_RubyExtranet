package com.ruby.controller;

import com.ruby.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadedFilesController {

    private UploadedFileService uploadedFileService;

    @Autowired
    public DownloadedFilesController(UploadedFileService uploadedFileService) {
        this.uploadedFileService = uploadedFileService;
    }

    public ModelAndView getDownloadFilesPage(ModelAndView model){

        model.addObject("files", uploadedFileService.getUploadedFiles());
        model.setViewName("downloadFilesList");
        return model;
    }
}
