package com.seisen.example.service;

import com.seisen.example.entity.UserEntity;
import com.seisen.example.exceptions.UserAlreadyExistException;
import com.seisen.example.exceptions.UserNotFoundException;
import com.seisen.example.model.User;
import com.seisen.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;




    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Такой пользователь уже существует");
        }
        return userRepository.save(user);

    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Такой пользователь не найден");
        }
        return User.toModel(user);
    }


    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
