package com.ruby.service;

import com.ruby.domain.UploadedFile;
import com.ruby.repository.UploadedFileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Blob;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by ShdwBt on 23/09/2017.
 */
public class UplaodedFileServiceImpl implements UploadedFileService {

    private UploadedFileRepository uploadedFileRepository;

    @Autowired
    public UplaodedFileServiceImpl(UploadedFileRepository uploadedFileRepository) {
        this.uploadedFileRepository = uploadedFileRepository;
    }

    @Override
    public void create(Blob file, String filename) {
        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setBlob(file);
        uploadedFile.setFilename(filename);

        uploadedFileRepository.save(uploadedFile);
    }

    @Override
    public Optional<UploadedFile> getByFilename(String filename) {
        return Optional.ofNullable(uploadedFileRepository.getUploadedFileByFilename(filename));
    }

    @Override
    public Collection<UploadedFile> getUploadedFiles() {
        return uploadedFileRepository.findAll();
    }
}
