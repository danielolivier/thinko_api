package com.thinko.api.session.service;

import com.thinko.api.session.model.DTO.SessionResponse;
import com.thinko.api.session.model.Session;
import com.thinko.api.session.repository.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {
    private final Logger logger = LoggerFactory.getLogger(SessionService.class);

    @Autowired
    SessionRepository sessionRepository;

    public List<SessionResponse> getSessionsByCourse(String courseId) {
        List<Session> sessions = new ArrayList<>();
        sessionRepository.findByCourseId(courseId).iterator().forEachRemaining(sessions::add);
        List<SessionResponse> responseList = new ArrayList<>();
        for (Session session : sessions) {
            SessionResponse response = new SessionResponse(session);
            responseList.add(response);
        }
        return responseList;
    }
}
