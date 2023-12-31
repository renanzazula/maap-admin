package com.maap.admin.function.jpa;

import com.maap.admin.domain.User;
import com.maap.admin.entity.UserEntity;

import java.util.function.Function;

public class UserEntityToUserFunction implements Function<UserEntity, User> {

    @Override
    public User apply(UserEntity input) {
        User output = new User();
        output.setId(input.getId());
        output.setName(input.getName());
        return output;
    }
}
