package com.rubyExtranet.service.uploadfile;

import java.sql.Blob;
import java.util.Collection;
import java.util.Optional;

import com.rubyExtranet.model.uploadfile.UploadFile;

public interface UploadFileService {
	
	UploadFile create(Blob file, String filename);
	
	Optional<UploadFile> getUploadFileByFilename(String filename); 
	
	Collection<UploadFile> getAllFiles();
}
