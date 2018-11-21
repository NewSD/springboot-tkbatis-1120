package com.niu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by ami on 2018/11/20.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userinfo")
public class UserInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


    public static class column {
        public static final String id = "id";
        public static final String username = "username";
        public static final String password = "password";
    }
}
