package com.example.demo.data.repositories.interfaces;

import com.example.demo.data.anemics.session.SessionAnemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends JpaRepository<SessionAnemic, String> {
}
