package com.example.User.service;

import com.example.User.exception.UserNotFoundException;
import com.example.User.model.User;
import com.example.User.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User addItem(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getItemById(Long itemId) throws UserNotFoundException {
        return userRepo.findById(itemId).orElseThrow(
                () -> new UserNotFoundException("No Such Item Found")
        );
    }

    @Override
    public List<User> getItems() {
        return userRepo.findAll();
    }

    @Override
    public User updateItem(Long itemId, User user) throws UserNotFoundException {
        User item1 = userRepo.findById(itemId).orElseThrow(
                () -> new UserNotFoundException("No Such Item Found")
        );

        item1.setName(Objects.isNull(user.getName()) ? item1.getName() : user.getName());
        return userRepo.save(item1);
    }

    @Override
    public void deleteItem(Long itemId) throws UserNotFoundException {
        User u = userRepo.findById(itemId).orElseThrow(
                () -> new UserNotFoundException("No Such Item Found By Id")
        );
        userRepo.delete(u);
    }
}

