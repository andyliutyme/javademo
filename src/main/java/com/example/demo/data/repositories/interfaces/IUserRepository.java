package com.example.demo.data.repositories.interfaces;

import com.example.demo.data.anemics.identity.UserAnemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserAnemic, String> {
}
