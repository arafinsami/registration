package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.entity.ConformationToken;

@Repository
public interface ConformationTokenRepository extends JpaRepository<ConformationToken, Long> {

}
