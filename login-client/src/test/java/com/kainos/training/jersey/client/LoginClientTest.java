package com.kainos.training.jersey.client;

/**
 * Created by conort on 25/10/2016.
 */

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginClientTest {

    private LoginClient client;

    @Before
    public void setup() {
        client = new LoginClient();
    }

    @Test
    public void getLogin_AnyDetails_ReturnBoolean() {
        Assert.assertTrue(client.getLogin("", "") || !client.getLogin("", ""));
    }

    @Test
    public void getLogin_CorrectDetails_ReturnTrue() {
        Assert.assertTrue(client.getLogin("admin", "password"));
    }

    @Test
    public void getLogin_InvalidUsername_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin("as", "password"));
    }

    @Test
    public void getLogin_InvalidPassword_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin("admin", "paord"));
    }

    @Test
    public void getLogin_EmptyDetails_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin("", ""));
    }

    @Test
    public void getLogin_EmptyUsername_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin("", "password"));
    }

    @Test
    public void getLogin_EmptyPassword_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin("admin", ""));
    }


    @Test
    public void getLogin_NullDetails_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin(null, null));
    }

    @Test
    public void getLogin_NullUsername_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin(null, "password"));
    }

    @Test
    public void getLogin_NullPassword_ReturnFalse() {
        Assert.assertEquals(false, client.getLogin("admin", null));
    }

}
