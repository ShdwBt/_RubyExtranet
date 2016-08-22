package com.ruby.rubyExtranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.ruby.rubyExtranet.service.uploadfile.UploadFileService;

@Controller
public class DownloalFilesController {
	
	private UploadFileService uploadFileService;
	
	@Autowired
	public DownloalFilesController(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}

	public ModelAndView getDownloadFilesPage(ModelAndView model){
		
		model.addObject("files", uploadFileService.getAllFiles());
		model.setViewName("downloadFilesList");
		return model;
	}
}
