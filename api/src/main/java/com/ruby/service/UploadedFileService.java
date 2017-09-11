package com.ruby.service;

import com.ruby.domain.UploadedFile;

import java.sql.Blob;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by ShdwBt on 11/09/2017.
 */
public interface UploadedFileService {
    UploadedFile create(Blob file, String filename);

    Optional<UploadedFile> getByFilename(String filename);

    Collection<UploadedFile> getUploadedFiles();
}
