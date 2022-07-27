package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    // 新增和修改
    @PostMapping
    public Integer save(@RequestBody User user) {
        // 新增或者更新
        return userService.save(user);
    }

    // 查询所有数据
    @GetMapping
    public List<User> index() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}