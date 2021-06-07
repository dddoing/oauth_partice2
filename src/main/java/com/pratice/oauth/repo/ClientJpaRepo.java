package com.pratice.oauth.repo;

import com.pratice.oauth.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientJpaRepo extends JpaRepository<Client,Long> {

    Client findByClientId (String clientName);
}
