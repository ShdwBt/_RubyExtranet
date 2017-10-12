package com.ruby.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by ShdwBt on 11/09/2017.
 */
@Getter @Setter
public class UserCreationForm {
    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    private String firstname;
    private String lastname;
    private String principalRole;
    private String additionalRole;

    @NotNull
    private String state;

    private String department;

}
