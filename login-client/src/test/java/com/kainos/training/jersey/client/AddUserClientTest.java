package com.kainos.training.jersey.client;

import com.kainos.training.jersey.client.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by conort on 25/10/2016.
 */
public class AddUserClientTest {

    private LoginClient client;

    @Before
    public void setup() {
        client = new LoginClient();
    }

    @Test
    public void addUser_ValidUser_Pass() {
        assertEquals(true, client.addUser("Conor", "test"));
    }


    @Test
    public void listUser_ValidUser_Pass() {
        //client.addUser("r","test");
//        for (User string : client.listUser()) {
//            System.out.println(string);
//        }
        System.out.println(client.listUser());
    }


}