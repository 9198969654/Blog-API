package com.codeWithDurgesh.blog.controllers;

import com.codeWithDurgesh.blog.payloads.ApiResponse;
import com.codeWithDurgesh.blog.payloads.UserDto;
import com.codeWithDurgesh.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //POST- create User
    @PostMapping
     public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
       UserDto createUserDto =   this.userService.createUser(userDto);
       return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
     }

    //PUT- put User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
       UserDto updatedUser =  this.userService.updateUser(userDto,uid);
       return ResponseEntity.ok(updatedUser);
    }

    //DELETE- delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new  ResponseEntity(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
    }

    //GET- get User
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    //Get SIngle User

    //GET- get User
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getAllUsers(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}























