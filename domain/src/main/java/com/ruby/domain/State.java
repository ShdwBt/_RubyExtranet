package com.ruby.domain;

import javax.persistence.*;

/**
 * Created by ShdwBt on 09/09/2017.
 */
@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pk_state_id", updatable = false, unique = true, nullable = false)
    private Integer id;

    @Column(name="state_text", unique=true, nullable=false)
    private String text;
}
