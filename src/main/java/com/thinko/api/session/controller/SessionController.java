package com.thinko.api.session.controller;

import com.thinko.api.session.model.DTO.SessionResponse;
import com.thinko.api.session.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Validated
@RequestMapping(path = "sessions", produces = { "application/json; charset=UTF-8" })
public class SessionController {
    private final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    SessionService sessionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SessionResponse> getSessionsByCourse(@RequestParam String courseId) { return sessionService.getSessionsByCourse(courseId); }
}
