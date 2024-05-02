package com.chae.book.springboot.config.auth.dto;

import com.chae.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getName();
        this.picture = user.getPicture();
    }
}
