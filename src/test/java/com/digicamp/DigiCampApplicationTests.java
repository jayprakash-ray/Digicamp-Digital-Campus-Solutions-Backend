package com.digicamp;

import com.digicamp.entity.LostAndFound;
import com.digicamp.service.RoleService;
import com.digicamp.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DigiCampApplicationTests extends AbstractTest{
    @Autowired
    private RoleService roleService;


    @Autowired
    private UserService userService;

    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mvc;
    @BeforeEach
    protected void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Order(1)
    void contextLoads() {
    }

    @Test
    @Order(2)
    void  getNotCollectedItemsTest() throws Exception
    {
        String  uri = "/lost-found/not-collected";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println(" Success");
        }catch(Exception e) {
            System.out.println(" Fail");
        }
        String  content = mvcResult.getResponse().getContentAsString();
//        List<User> userList = super.mapFromJson(content, List.class);

    }


    @Test
    @Order(3)
    void  getAllPackagesTest() throws Exception
    {
        String  uri = "/history";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println(" Success");
        }catch(Exception e) {
            System.out.println(" Fail");
        }
        String  content = mvcResult.getResponse().getContentAsString();
//        List<User> userList = super.mapFromJson(content, List.class);

    }

    @Test
    @Order(4)
    void  addItemTest() throws Exception
    {
        String user = "{\"username\":\"test\",\"password\":\"test\",\"email\":\"test@manager.org\",\"phone\":\"7894561230\",\"name\":\"test\",\"businessTitle\":\"manager\"}";
        String  uri = "/lost-found";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        String content = mvcResult.getResponse().getContentAsString();
        try {
            assertEquals( 200, status);
            System.out.println(" Success");
        }catch(Exception e) {
            System.out.println(" Fail");
        }
//
    }
}
