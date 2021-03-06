package com.derek.model;

import javax.persistence.Id;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 6973443089286692944L;
    @Id
    private Integer id;

    private String username;

    private String password;

    private Byte type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}