package com.pratice.oauth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

    @Id
    private String authenticateId;

    private String accessToken;
    private String clientId;
    private String refreshToken;

    @Override
    public String toString() {
        return "id [" + authenticateId + "] access [" + accessToken + "] refresh[ " +refreshToken + "] cid [" + clientId + "] ";
    }
}
