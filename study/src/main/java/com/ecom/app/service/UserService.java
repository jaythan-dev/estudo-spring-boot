package com.ecom.app;

import com.ecom.app.model.User;
import com.ecom.app.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
    public boolean updateUser(Long id, User updatedUser){
        return userRepository.findById(id)
                .map(existingUser ->{
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);
    }
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new EmptyResultDataAccessException(1);
        }
        userRepository.deleteById(id);
    }

}