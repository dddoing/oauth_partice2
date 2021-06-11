package com.pratice.oauth.repo;

import com.pratice.oauth.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenJpaRepo extends JpaRepository<Token,Long> {


}
