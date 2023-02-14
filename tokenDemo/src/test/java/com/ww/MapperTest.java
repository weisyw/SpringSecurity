package com.ww;

import com.ww.domain.entity.User;
import com.ww.mapper.MenuMapper;
import com.ww.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testSelectPermsByUserId(){
        List<String> list = menuMapper.selectPermsByUserId(2L);
        list.forEach(System.out::println);
    }


    @Test
    public void TestBCryptPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
    }


    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}