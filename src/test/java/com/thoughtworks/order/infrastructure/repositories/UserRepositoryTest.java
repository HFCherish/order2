package com.thoughtworks.order.infrastructure.repositories;

import com.thoughtworks.order.domain.User;
import static com.thoughtworks.order.support.TestHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.thoughtworks.order.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Optional;

@RunWith(ApiTestRunner.class)
public class UserRepositoryTest {

    @Inject
    UserRepository userRepository;

    @Test
    public void should_save_and_get_user_successful() {
        User user = userForTest(VALID_USER_NAME);

        userRepository.save(user);
        Optional<User> fetched = userRepository.findById(user.getId());

        assertThat(fetched.isPresent(), is(true));
        User fetchedUser = fetched.get();
        assertThat(fetchedUser.getId(), is(user.getId()));
        assertThat(fetchedUser.getName(), is(user.getName()));
    }

}
