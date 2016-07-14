package com.thoughtworks.order.web;

import com.thoughtworks.order.support.ApiSupport;
import com.thoughtworks.order.support.ApiTestRunner;
import static com.thoughtworks.order.support.TestHelper.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(ApiTestRunner.class)
public class UsersApiTest extends ApiSupport {
//    @Inject
//    UserRepository userRepository;

    @Test
    public void should_register_user_successful() throws Exception {
        Map<String, Object> userInfo = userJsonForTest(VALID_USER_NAME);

        final Response response = target("users/").request().post(Entity.json(userInfo));
        assertThat(response.getStatus(), is(201));
        assertThat(response.getLocation().toString(), containsString("users/"));
    }

    @Test
    public void should_400_when_register_user_given_wrong_name_pattern() {
        Response response = target("users/").request().post(Entity.json(userJsonForTest(INVALID_USER_NAME)));
        assertThat(response.getStatus(), is(400));
    }

    //
//    @Test
//    public void should_400_if_id_not_valid() throws Exception {
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("email", "scxu@thoughtworks.com");
//            put("name", "Xu Shanchuan");
//            put("role", "Dev");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(400));
//    }
//
//    @Test
//    public void should_400_if_email_not_valid() throws Exception {
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("id", "123");
//            put("name", "Xu Shanchuan");
//            put("role", "Dev");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(400));
//    }
//
//    @Test
//    public void should_400_when_create_user_if_user_exist() throws Exception {
//        final User user = TestHelper.userForTest("123", "scxu", UserRole.DEV);
//        userRepository.save(user);
//
//        Map<String, Object> userInfo = new HashMap<String, Object>() {{
//            put("id", "123");
//            put("name", "scxu");
//            put("email", "scxu@tw.com");
//            put("role", "Dev");
//        }};
//
//        final Response post = post("/users", userInfo);
//        assertThat(post.getStatus(), is(400));
//    }
//
//    @Test
//    public void should_get_user_by_id() throws Exception {
//        final User user = TestHelper.userForTest("123", "scxu", UserRole.DEV);
//        userRepository.save(user);
//
//        final Response response = get("/users/" + user.getUserId().id());
//        assertThat(response.getStatus(), is(200));
//        final Map userMap = response.readEntity(Map.class);
//        assertThat(userMap.get("id"), is(user.getUserId().id()));
//        assertThat(userMap.get("name"), is(user.getName()));
//        assertThat(userMap.get("email"), is(user.getEmail()));
//        List urls = (List) userMap.get("links");
//        assertThat(urls.size(), is(1));
//        assertThat(canFindLink(urls, "self", "/users/123"), is(true));
//    }
//
//    @Test
//    public void should_404_if_user_not_exist() throws Exception {
//        final Response response = get("/users/abc");
//        assertThat(response.getStatus(), is(404));
//    }
}
