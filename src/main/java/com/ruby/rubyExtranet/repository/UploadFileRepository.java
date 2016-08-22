package com.ruby.rubyExtranet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.rubyExtranet.model.uploadfile.UploadFile;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
	UploadFile getUploadFileByFileName(String fileName); 
}
	