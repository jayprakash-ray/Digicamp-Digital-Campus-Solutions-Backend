package com.digicamp.service;

import org.springframework.stereotype.Service;

public interface EmailAuthenticationService {
    boolean sendEmail(String message, String subject, String to);

}
