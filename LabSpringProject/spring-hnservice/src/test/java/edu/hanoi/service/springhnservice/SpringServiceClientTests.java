package edu.hanoi.service.springhnservice;

import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.List;

@RunWith(JUnit4.class)
public class SpringServiceClientTests {
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = builder.build();
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }

    //    @Test
//    public void contextLoads(){
//        String address = "http://localhost:8080/user/list";
//        ResponseEntity<List> entity = restTemplate.getForEntity(address,List.class);
//        List<User> users =(List<User>) entity.getBody();
//        Assert.assertTrue(users.size() > 0);
//    }
//    @Test
//    public void contextLoads(){
//        String address = "http://localhost:8080/group/list";
//        ResponseEntity entity = restTemplate.getForEntity(address, Group[].class);
//        Group[] groups = (Group[]) entity.getBody();
//        Assert.assertTrue(groups.length >0);
//        for (int i = 0; i < groups.length; i++) {
//            System.out.println(groups[i].getName());
//        }
//    }
    @Test
    public void contextLoads() {
//        String address = "http://localhost:8080/user/add";
//
//        User user = new User();
//        user.setUsername("test2");
//        user.setPassword("123456");
//        user.setAge(25);
//        user.setGroupId(1);
//        user.setEmail("test2@example.com");
//
//        ResponseEntity entity = restTemplate.postForEntity(address,user, String.class);
//        Assert.assertEquals(user.getUsername(),entity.getBody());

//        String address = "http://localhost:8080/user/get/test1";
//        ResponseEntity<User> entity = restTemplate.getForEntity(address, User.class);
//        Assert.assertEquals("123456",entity.getBody().getPassword());
//        System.out.println(entity.getBody().getEmail());

//        String address = "http://localhost:8080/user/get/test1";
//        ResponseEntity<User> entity = restTemplate.getForEntity(address, User.class);
//        Assert.assertEquals("123456", entity.getBody().getPassword());
//        System.out.println(entity.getBody().getEmail());
//
//        address = "http://localhost:8080/user/delete/test1";
//        ResponseEntity delEntity = restTemplate.getForEntity(address, Void.class);
//
//        address = "http://localhost:8080/user/get/test1";
//        ResponseEntity<User> entitylast = restTemplate.getForEntity(address, User.class);
//        Assert.assertEquals(null,entitylast.getBody());

        String address = "http://localhost:8080/user/get/test2";
        ResponseEntity<User> entity = restTemplate.getForEntity(address, User.class);
        User user = entity.getBody();
        Assert.assertNotNull(user);

        user.setPassword("654321");
        address = "http://localhost:8080/user/update";
        restTemplate.postForEntity(address,user, Void.class);

        address = "http://localhost:8080/user/get/test2";
        ResponseEntity<User> entity2 = restTemplate.getForEntity(address, User.class);
        Assert.assertEquals(user.getPassword(),entity2.getBody().getPassword());

    }
}
