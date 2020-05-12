package com.example.user_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.usermanagement.UserManagementApplication;
import com.example.usermanagement.entity.User;

@SpringBootTest(classes = UserManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testAddUser() throws Exception {
		User user = User.builder().id(22L).age("22").firstName("ajna").lastName("rana").build();

		ResponseEntity<String> postResponse = restTemplate.postForEntity(createURLWithPort("/user"), user, String.class);
		assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

	}

	@Test
	public void testGetUsers() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/users"), HttpMethod.GET,
				entity, String.class);

		assertNotNull(response.getBody());
	}

	@Test
	public void testGetUsersById() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/users/22"), HttpMethod.GET,
				entity, String.class);
		assertNotNull(response.getBody());
	}
	
	 @Test
	    public void testUpdateUserById() {
	        User user = restTemplate.getForObject(createURLWithPort("/users/22") , User.class);
	        user.setFirstName("ramya");
	        user.setLastName("sharma");
	        user.setAge("20");
	        restTemplate.put(createURLWithPort("/users/22"), user);
	        User updatedUser = restTemplate.getForObject(createURLWithPort("/users/22"), User.class);
	        assertNotNull(updatedUser);
	    }
	 
	 @Test
	    public void testDeleteUserById() {
	         User user = restTemplate.getForObject(createURLWithPort("/users/22"), User.class);
	         assertNotNull(user);
	         restTemplate.delete(createURLWithPort("/users/22"));
	         try {
	              user = restTemplate.getForObject(createURLWithPort("/users/22"), User.class);
	         } catch (final HttpClientErrorException e) {
	              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	         }
	    }
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	
}
