package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.session.SessionAnemic;
import com.example.demo.data.repositories.interfaces.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionRepositoryService {
    @Autowired
    private ISessionRepository repository;

    public List<SessionAnemic> getSessions() {
        return this.repository.findAll();
    }

    public void saveChanges(SessionAnemic session)
    {
        this.repository.save(session);
    }

    public SessionAnemic getSessionById(String id) {
        return this.repository.getOne(id);
    }

    public SessionAnemic getSessionByUserId(String userId)
    {
        var sessions = this.getSessions();
        if (sessions == null || sessions.isEmpty())
        {
            return null;
        }

        for (var session: sessions)
        {
            if (session.getUser().getId().equals(userId))
            {
                return session;
            }
        }

        return null;
    }
}
