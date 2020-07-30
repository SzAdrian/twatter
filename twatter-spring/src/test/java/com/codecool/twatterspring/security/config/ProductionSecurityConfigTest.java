package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.redis.TimelineRepository;
import com.codecool.twatterspring.security.JwtFilter;
import com.codecool.twatterspring.security.service.AuthService;
import com.codecool.twatterspring.security.service.JwtService;
import com.codecool.twatterspring.service.TimelineService;
import com.codecool.twatterspring.service.TweetService;
import com.codecool.twatterspring.service.dao.TwatterUserDao;
import com.codecool.twatterspring.service.dao.TwatterUserDaoDb;
import com.codecool.twatterspring.service.dao.mem.TwatterUserDaoMem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@ActiveProfiles({"test", "security", "no_db"})
@Import({AuthService.class, JwtService.class, TwatterUserDaoMem.class, JwtFilter.class})
class ProductionSecurityConfigTest {

    @MockBean
    private TimelineRepository timelineRepository;
    
    @MockBean
    private TimelineService timelineService;
    
    @MockBean
    private TweetService tweetService;
    
    @Test
    void smokeTest() {
    }
}