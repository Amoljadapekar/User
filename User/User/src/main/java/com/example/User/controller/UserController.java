package com.example.User.controller;

import com.example.User.model.User;
import com.example.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")

public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users")
    public ResponseEntity<User> createItem(@RequestBody User user){
        return new ResponseEntity<User>(userService.addItem(user), HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getItem(@PathVariable("id")Long itemId){
        return ResponseEntity.ok().body(userService.getItemById(itemId));
    }
    @GetMapping("/users")
    public List<User> getItems(){
        return userService.getItems();
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateItem(@PathVariable("id") Long itemId,@RequestBody User user){
        return ResponseEntity.ok((userService.updateItem(itemId,user)));
    }
    @DeleteMapping("users/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") Long itemId){
        userService.deleteItem(itemId);
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }
}
