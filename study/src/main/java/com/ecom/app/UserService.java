package com.ecom.app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final userRepository userRepository;

    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    public void changeFirstName(Long id, String newName){

    }
    public boolean updateUser(Long id, User updatedUser){
        return userRepository.findById(id)
                .map(existingUser ->{
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    userRepository.save(updatedUser);
                    return true;
                }).orElse(false);
    }

}