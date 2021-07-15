package com.pratice.oauth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.security.util.Length;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="oauth_code")
public class Code {

    @Id
    @Column(length=4000)
    byte[] authentication;

    @Column
    String code;
}
