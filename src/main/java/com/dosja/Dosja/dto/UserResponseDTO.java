package com.dosja.Dosja.dto;

import com.dosja.Dosja.model.Auditable;
import com.dosja.Dosja.model.Role;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class UserResponseDTO  extends Auditable {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;

    @ApiModelProperty(position = 2)
    private String full_name;
    @ApiModelProperty(position = 3)
    private String email;
    @ApiModelProperty(position = 4)
    List<Role> roles;

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
