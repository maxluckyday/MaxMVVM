package com.isawesome.maxli.maxmvvm.repository;

import com.isawesome.maxli.maxmvvm.model.User;

public class MaxMVVMRepository {

    private static MaxMVVMRepository instance;
    private User repoUser;

    public static MaxMVVMRepository getInstance() {
        if (instance == null) {
            instance = new MaxMVVMRepository();
        }
        return instance;
    }

    public User getUserFromAPI() {
        //simulate api call
        setUserFake();
        return repoUser;
    }

    public void setUser(User user) {
        //this should be an api call, on success
        repoUser = user;
    }

    public User getUserFromRepository() {
        return repoUser;
    }

    private void setUserFake() {
        repoUser = new User("Max", "Li", "max@luckydayapp.com", "6269406786");
    }
}