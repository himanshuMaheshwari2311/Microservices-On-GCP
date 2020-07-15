package com.stark.profileservice.service;

import com.stark.profileservice.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Override
    public Profile create(String emailId) {
        return null;
    }

    @Override
    public Profile get(String emailId) {
        return null;
    }

    @Override
    public Profile update(Profile profile) {
        return null;
    }

    @Override
    public boolean delete(String emailId) {
        return false;
    }
}
