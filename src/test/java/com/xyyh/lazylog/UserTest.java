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

    /**
     * 运行该测试给数据库添加数据
     */
    @Test
    @Transactional
    @Rollback(false)
    public void addUser() {
        User user = new User();
        user.setName("1");
        user.setDescription("descript1");
        user.setMemo("memo1");
        userRepository.save(user);
    }

    /**
     * 该测试仅加载基本字段
     */
    @Test
    public void loadOnlyName() {
        List<User> users = userRepository.findAll();
        users.forEach(i -> {
            System.out.println(i.getName());
        });
    }

    /**
     * 按需要加载其它字段
     */
    @Test
    @Transactional
    public void loadAll() {
        List<User> users = userRepository.findAll();
        users.forEach(i -> {
            System.out.println("username=[" + i.getName() + "]");
            System.out.println("descript=[" + i.getDescription() + "]");
            System.out.println("memo=[" + i.getMemo() + "]");
        });
    }
}
