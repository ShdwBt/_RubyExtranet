package com.rubyExtranet.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.type.ByteArrayBlobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubyExtranet.repository.UploadFileRepository;
import com.rubyExtranet.service.uploadfile.UploadFileService;

@Controller
public class FileUploadController {

	//temporary folder
	public static final String ROOT = "upload-dir";

	private final ResourceLoader resourceLoader;
	
	private UploadFileService uploadFileService;


	@Autowired
	public FileUploadController(ResourceLoader resourceLoader, UploadFileService uploadFileService) {
		this.resourceLoader = resourceLoader;
		this.uploadFileService = uploadFileService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/uploadFileForm")
	public String provideUploadInfo(Model model) throws IOException {
		model.addAttribute("files", Files.walk(Paths.get(ROOT))
				.filter(path -> !path.equals(Paths.get(ROOT)))
				.map(path -> Paths.get(ROOT).relativize(path))
				.map(path -> linkTo(methodOn(FileUploadController.class).getFile(path.toString())).withRel(path.toString()))
				.collect(Collectors.toList())
		);
		return "uploadFileForm";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/uploadFileForm + {filename:.+}")
	@ResponseBody
	public ResponseEntity<?> getFile(@PathVariable String filename) {

		try {
			return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/uploadFileForm + {filename:.+}")
//	@ResponseBody
//	public ResponseEntity<?> getFile(@PathVariable String filename) {
//
//		try {
//			Optional<UploadFile> getFile= uploadFileService.getUploadFileByFilename(filename);
//			//return getFile.get();
//			//return ResponseEntity.ok(resourceLoader.getResource("file:" + getFile).toString());
//			return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
//
//		} catch (Exception e) {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
////	@RequestMapping(method = RequestMethod.GET, value = "/uploadFileForm2 + {filename:.+}")
////	@ResponseBody
////	public InputStream getFile2(@PathVariable String filename) throws SQLException {
////		
////		Optional<UploadFile> getFile= uploadFileService.getUploadFileByFilename(filename);
////		return getFile.get().getUploadFileBlob().getBinaryStream();
////
////	}

	@RequestMapping(method = RequestMethod.POST, value = "/uploadFileForm")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
								   RedirectAttributes redirectAttributes) throws SerialException, SQLException {

		if (!file.isEmpty()) {
			try {
				Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
				redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename());
				
				System.out.println(file.getOriginalFilename());
				byte[] biteFileToUpload = file.getBytes();
				//InputStream streamBlob = file.getInputStream();
				SerialBlob fileBlob = new SerialBlob(biteFileToUpload);
				uploadFileService.create(fileBlob, file.getOriginalFilename());
				
			} catch (IOException|RuntimeException e) {
				redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
		}

		return "redirect:/uploadFileForm";
	}
	
}
