package com.pro.userservice.repository;

import com.pro.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPhoneCountryCodeAndPhoneNumber(String countryCode, String phoneNumber);

    Optional<User> findByUuid(UUID uuid);

}
