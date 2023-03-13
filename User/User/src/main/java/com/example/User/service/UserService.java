package com.example.User.service;

import com.example.User.exception.UserNotFoundException;
import com.example.User.model.User;

import java.util.List;

public interface UserService {
    User addItem(User user);
    User getItemById(Long itemId) throws UserNotFoundException;
    List<User> getItems();
    User updateItem(Long itemId,User user) throws UserNotFoundException;
    void deleteItem(Long itemId) throws UserNotFoundException;
}
