package com.thoughtworks.order.infrastructure.mybatis.mappers;

import com.thoughtworks.order.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User ofId(@Param("id") String id);

    void save(@Param("user") User user);

    User findByUserName(@Param("userName") String userName);
}
