package com.ruby.rubyExtranet.model.uploadfile;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upload_file")
public class UploadFile {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "pk_upload_file_id", updatable = false)
	private Integer uploadFileId;
	
	@Column(name="file", nullable=false)
	private Blob uploadFileBlob;
	
	@Column(name="filename", nullable=false)
	private String fileName;

	public Integer getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(Integer uploadFileId) {
		this.uploadFileId = uploadFileId;
	}

	public Blob getUploadFileBlob() {
		return uploadFileBlob;
	}

	public void setUploadFileBlob(Blob uploadFileBlob) {
		this.uploadFileBlob = uploadFileBlob;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
