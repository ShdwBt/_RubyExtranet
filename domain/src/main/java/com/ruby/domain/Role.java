package com.ruby.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ShdwBt on 09/09/2017.
 */
@Entity
@Table(name = "role")
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pk_role_id", updatable = false, unique = true, nullable = false)
    private Integer id;

    @Column(name="role_text", unique=true, nullable=false)
    private String text;
}
