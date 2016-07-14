package com.thoughtworks.order.infrastructure.mybatis.mappers;

import com.thoughtworks.order.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void save(@Param("user") User user);

    User findById(@Param("id") String id);
}
