package com.ecommerce.EcommerceTest.Users;

import com.ecommerce.EcommerceTest.Cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.List;
import java.util.Optional;
@Service
public class UsersService {

private final UsersRepository usersRepository;
@Autowired
public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        }

public static List<User> getUsers(UsersRepository
                                           usersRepository) {
        return usersRepository.findAll();
        }




public void addNewUser(User user) {
        Optional<User> usersByEmail = usersRepository.findUsersByEmail(user.getEmail());
        if(usersByEmail.isPresent()){
                throw  new IllegalStateException("email is taken");

        }
        usersRepository.save(user);
        System.out.println("user created");

        }
        public static void deleteUser(Long id, UsersRepository usersRepository) {

                boolean b = usersRepository.existsById(id);
                if (!b) {

                        throw new IllegalStateException("student is unnormal");
                }
                usersRepository.deleteById(id);

        }




        }

