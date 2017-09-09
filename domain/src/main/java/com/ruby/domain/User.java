package com.ruby.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ShdwBt on 09/09/2017.
 */
@Entity
@Table (name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "pk_user_id", updatable = false)
    private Integer id;

    @Column(name="first_name", nullable=false)
    private String firstname;

    @Column(name="last_name", nullable=false)
    private String lastname;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="email", nullable=false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = { @JoinColumn(name = "fk_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "fk_role_id") })
    private Collection<Role> roles = new ArrayList<Role>();

    @ManyToOne
    @JoinColumn (name = "fk_department_id")
    private Department department;

    @ManyToOne
    @JoinColumn (name = "fk_state_id")
    private State state;
}
