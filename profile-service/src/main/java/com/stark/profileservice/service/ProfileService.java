package com.stark.profileservice.service;

import com.stark.profileservice.model.Profile;

public interface ProfileService {
    Profile create(String emailId);
    Profile get(String emailId);
    Profile update(Profile profile);
    boolean delete(String emailId);
    String testService();
}
