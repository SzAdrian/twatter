package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.redis.TimelineRepository;
import com.codecool.twatterspring.security.JwtFilter;
import com.codecool.twatterspring.security.service.AuthService;
import com.codecool.twatterspring.security.service.JwtService;
import com.codecool.twatterspring.security.service.TwatterUserDetailsService;
import com.codecool.twatterspring.service.TimelineService;
import com.codecool.twatterspring.service.TweetService;
import com.codecool.twatterspring.service.dao.mem.TwatterUserDaoMem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"test", "security", "no_db"})
@Import({AuthService.class, JwtService.class, TwatterUserDaoMem.class, JwtFilter.class, TwatterUserDetailsService.class})
abstract class AbstractControllerSecurityTest {

    static final String BASE_URL = "/api";
    static final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    TimelineRepository timelineRepository;

    @MockBean
    TimelineService timelineService;

    @MockBean
    TweetService tweetService;
}
