package com.ruby.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by ShdwBt on 09/09/2017.
 */
@Entity
@Table(name = "uploaded_file")
@Getter @Setter
public class UploadedFile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "pk_uploaded_file_id", updatable = false)
    private Integer id;

    @Column(name="file", nullable=false)
    private Blob blob;

    @Column(name="filename", nullable=false)
    private String filename;
}
