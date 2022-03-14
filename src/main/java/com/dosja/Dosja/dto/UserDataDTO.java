package com.dosja.Dosja.dto;

import com.dosja.Dosja.model.Auditable;
import com.dosja.Dosja.model.Role;
import com.dosja.Dosja.model.Users;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class UserDataDTO extends Users {

    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String full_name;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    private String password;
    @ApiModelProperty(position = 4)
    List<Role> roles;

    @ApiModelProperty(position = 6)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

}
