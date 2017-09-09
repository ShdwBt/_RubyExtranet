package com.ruby.domain;

import javax.persistence.*;

/**
 * Created by ShdwBt on 09/09/2017.
 */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "pk_department_id", updatable = false)
    private Integer id;

    @Column(name="department_text", unique=true, nullable=true)
    private String text;
}
