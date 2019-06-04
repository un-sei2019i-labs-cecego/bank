package com.example.applogin.BusinessLogic;

import android.content.Context;

import com.example.applogin.DataAccess.Repositories.UserRepository;

public class Login {
    private Context context;
    private UserRepository userRepository;

    public Login(Context context) {
        this.context = context;
        userRepository = new UserRepository(context);

    }

    public boolean login(long id, int password) {

        if (userRepository.getUserById(id) != null && (long) userRepository.getUserById(id).getPassword() == password){
            return true;
        }
        return false;

    }
}
