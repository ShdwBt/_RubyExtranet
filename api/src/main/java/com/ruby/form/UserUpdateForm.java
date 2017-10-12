package com.ruby.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by ShdwBt on 11/09/2017.
 */
@Getter @Setter
public class UserUpdateForm {
    @NotNull
    private Integer id;

    @NotEmpty
    private String email = "";

    private String firstname;
    private String lastname;
    private String department;
    private String state;
}
