package net.hnkj.springboot0202.service.impl;

import net.hnkj.springboot0202.model.User;
import net.hnkj.springboot0202.service.IUserService;
import net.hnkj.springboot0202.utils.PageBean;
import net.hnkj.springboot0202.utils.PasswordHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void insertSelective() {
        //用来注册
        user.setUsername("lixin");
        String salt = PasswordHelper.createSalt();
        String creadtials = PasswordHelper.createCredentials("88888",salt);
        user.setSalt(salt);
        user.setPassword(creadtials);
        userService.insertSelective(user);
    }

    @Test
    void listUser() {
        List<User> users = userService.listUser(user, new PageBean());
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    void selectUserByUsername() {
        User name = userService.selectUserByUsername("lixin");
        System.out.println(name);

    }
}