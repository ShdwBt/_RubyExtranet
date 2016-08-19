package com.rubyExtranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubyExtranet.model.uploadfile.UploadFile;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
	UploadFile getUploadFileByFileName(String fileName); 
}
	