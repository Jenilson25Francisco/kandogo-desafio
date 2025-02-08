package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.sutainable.Sutainable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SutainableRepository extends JpaRepository<Sutainable, String> {
}
