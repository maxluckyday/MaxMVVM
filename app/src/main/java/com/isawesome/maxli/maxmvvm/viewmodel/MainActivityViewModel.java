package com.isawesome.maxli.maxmvvm.viewmodel;

import com.isawesome.maxli.maxmvvm.model.User;
import com.isawesome.maxli.maxmvvm.repository.MaxMVVMRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<User> viewModelLiveDataUser;
    private MaxMVVMRepository repo;

    public void init() {
        if (viewModelLiveDataUser != null) {
            return;
        }
        viewModelLiveDataUser = new MutableLiveData<>();
        repo = MaxMVVMRepository.getInstance();
        viewModelLiveDataUser.setValue(repo.getUserFromAPI());
    }

    public void changeUserValue(String firstName, String lastName, String email, String phoneNumber) {
        repo.setUser(new User(firstName, lastName, email, phoneNumber));
        viewModelLiveDataUser.setValue(repo.getUserFromRepository());
    }

    public LiveData<User> getUser() {
        return viewModelLiveDataUser;
    }
}
