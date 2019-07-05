package com.project.manager.projectmanagerapi.controller;


import com.project.manager.projectmanagerapi.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void testAddUser() throws Exception{

    }
}