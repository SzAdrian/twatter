package com.codecool.twatterspring.security.service;

import com.codecool.twatterspring.model.TwatterUserDTO;
import com.codecool.twatterspring.service.dao.TwatterUserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TwatterUserDetailsService implements UserDetailsService {

    private final TwatterUserDao userDao;

    public TwatterUserDetailsService(TwatterUserDao twatterUserDao) {
        this.userDao = twatterUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findBy(username)
            .map(TwatterUserDTO::asUserDetails)
            .orElseThrow((() -> new UsernameNotFoundException("Bad credentials.")));
    }
}
