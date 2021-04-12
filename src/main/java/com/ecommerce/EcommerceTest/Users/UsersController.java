package com.ecommerce.EcommerceTest.Users;

import com.ecommerce.EcommerceTest.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "api/v3/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UsersController {
    private final UsersService usersService;
    private final UsersRepository usersRepository;
@Autowired
    public UsersController(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }
    @GetMapping
    public List<User> getUsers(){
        return usersService.getUsers(usersRepository);
    }
    @PostMapping
    public void addNewUsers(@RequestBody User user){
        usersService.addNewUser(user);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id")Long id){
        usersService.deleteUser(id,usersRepository);
    }





}

