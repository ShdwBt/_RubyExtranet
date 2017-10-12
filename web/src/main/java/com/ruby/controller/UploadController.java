package com.ruby.controller;

import com.ruby.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by ShdwBt on 24/09/2017.
 */
@Controller
public class UploadController {
    //temporary folder
    public static final String ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    private UploadedFileService uploadedFileService;

    @Autowired
    public UploadController(ResourceLoader resourceLoader, UploadedFileService uploadedFileService) {
        this.resourceLoader = resourceLoader;
        this.uploadedFileService = uploadedFileService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uploadFileForm")
    public String provideUploadInfo(Model model) throws IOException {
        model.addAttribute("files", Files.walk(Paths.get(ROOT))
                .filter(path -> !path.equals(Paths.get(ROOT)))
                .map(path -> Paths.get(ROOT).relativize(path))
                .map(path -> linkTo(methodOn(UploadController.class).getFile(path.toString())).withRel(path.toString()))
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
                uploadedFileService.create(fileBlob, file.getOriginalFilename());

            } catch (IOException|RuntimeException e) {
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }

        return "redirect:/uploadFileForm";
    }
}
