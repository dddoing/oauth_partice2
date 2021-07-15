package com.pratice.oauth.repo;

import com.pratice.oauth.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeJpaRepo extends JpaRepository<Code,Long> {
    //
    Optional<Code> findByAuthentication(byte[] authentication);
}
