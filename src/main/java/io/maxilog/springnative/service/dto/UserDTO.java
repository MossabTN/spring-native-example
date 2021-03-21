package io.maxilog.springnative.service.dto;

import com.sun.istack.NotNull;
import io.maxilog.springnative.domaine.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
