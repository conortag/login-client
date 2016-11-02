package com.kainos.training.login.service.resource;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginResourceTest {

	private LoginResource loginResource;

	@Before
	public void setup(){
		loginResource =  new LoginResource("admin","password");

	}

	@Test
	public void loginWithCorrectDetailsReturnsOkResponse() {
		// act
		Response response = loginResource.login("admin", "password");
		// assert
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		Assert.assertEquals("Success!", response.getEntity());
	}

	@Test
	public void loginWithInvalidDetailsReturnsUnauthorizedResponse(){
		// act
		Response response = loginResource.login("afmin", "password");
		// assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Incorrect username or password", response.getEntity());
	}

	@Test
    public void loginWithValidDetailsWrongCaseUsernameReturnsOkResponse(){
        Response response = loginResource.login("ADMIN","password");
        // assert
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    }

    @Test
    public void loginWithValidDetailsWrongCasePasswordReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN","pasSword");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithInvalidSymbolPasswordReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN","pas$$word");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithNewLineUsernameReturnsUnauthorized(){
        Response response = loginResource.login("AD/nMIN","password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithNewLinePasswordReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN","pa/nssword");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithSpacingPrefixUsernameReturnsUnauthorized(){
        Response response = loginResource.login("  ADMIN","password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithSpacingSuffixUsernameReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN  ","password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithSpacingPaddingUsernameReturnsUnauthorized(){
        Response response = loginResource.login(" ADMIN ","password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithSpacingPrefixPasswordReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN"," password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithSpacingSuffixPasswordReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN","password ");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithSpacingPaddingPasswordReturnsUnauthorized(){
        Response response = loginResource.login("ADMIN"," password ");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithNullDetailsReturnsUnauthorized(){
        Response response = loginResource.login(null,null);
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithNullUsernameReturnsUnauthorized(){
        Response response = loginResource.login(null,"password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void loginWithNullPasswordReturnsUnauthorized(){
        Response response = loginResource.login("admin",null);
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void login_W_ReturnsUnauthorized(){
        Response response = loginResource.login("/r","password");
        // assert
        Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

}
