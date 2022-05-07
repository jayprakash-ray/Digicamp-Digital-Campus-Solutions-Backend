package com.digicamp.service;

import com.digicamp.dao.UserDao;
import com.digicamp.entity.JwtRequest;
import com.digicamp.entity.JwtResponse;
import com.digicamp.entity.User;
import com.digicamp.configuration.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {

        String userId = jwtRequest.getUserId();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userId, userPassword);

        UserDetails userDetails = loadUserByUsername(userId);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userDao.findByUserId(userId);
        System.out.println("userDao" +user);
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDao.findByUserId(userId);
        System.out.println("User"+user);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    String.valueOf(user.getUserId()),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with ID: " + userId);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
        return authorities;
    }

    private void authenticate(String userId, String userPassword) throws Exception {
        try {
            System.out.println(userId+"|"+userPassword);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            System.out.println("Bad Cred");
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
