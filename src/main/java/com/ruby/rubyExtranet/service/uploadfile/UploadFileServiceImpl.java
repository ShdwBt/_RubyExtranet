package com.ruby.rubyExtranet.service.uploadfile;

import java.sql.Blob;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.rubyExtranet.model.uploadfile.UploadFile;
import com.ruby.rubyExtranet.repository.UploadFileRepository;

@Service	
public class UploadFileServiceImpl implements UploadFileService {

	private UploadFileRepository uploadFileRepository;
	
	@Autowired
	public UploadFileServiceImpl(UploadFileRepository uploadFileRepository) {
		this.uploadFileRepository = uploadFileRepository;
	}

	@Override
	public UploadFile create(Blob file, String filename) {
		UploadFile uploadFile = new UploadFile();
		
		uploadFile.setUploadFileBlob(file);
		uploadFile.setFileName(filename);
		uploadFileRepository.save(uploadFile);
		return null;
	}

	@Override
	public Optional<UploadFile> getUploadFileByFilename(String filename) {
		return Optional.ofNullable(uploadFileRepository.getUploadFileByFileName(filename));
	}

	@Override
	public Collection<UploadFile> getAllFiles() {
		return uploadFileRepository.findAll();
	}

	
	
}
