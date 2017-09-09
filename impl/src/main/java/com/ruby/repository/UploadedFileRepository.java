package com.ruby.repository;

import com.ruby.domain.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ShdwBt on 09/09/2017.
 */
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
    UploadedFile getUploadedFileByFilename(String filename);
}
