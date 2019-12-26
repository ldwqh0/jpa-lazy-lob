package com.xyyh.lazylog;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.xyyh.lazylob.LazyLobApplication;
import com.xyyh.lazylob.entity.User;
import com.xyyh.lazylob.repository.UserRepository;

@SpringBootTest(classes = LazyLobApplication.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void addUser() {
        User user = new User();
        user.setName("1");
        user.setDescript("descript1");
        userRepository.save(user);
    }

    @Test
    public void loadOnlyName() {
        List<User> users = userRepository.findAll();
        users.forEach(i -> {
            System.out.println(i.getName());
        });
    }

    @Test
    @Transactional
    public void loadAll() {
        List<User> users = userRepository.findAll();
        users.forEach(i -> {
            System.out.println("username=[" + i.getName() + "]");
            System.out.println("descript=[" + i.getDescript() + "]");
        });
    }
}
