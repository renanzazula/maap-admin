package com.maap.admin.function.jpa;

import com.maap.admin.domain.User;
import com.maap.admin.entity.UserEntity;

import java.util.function.Function;

public class UserEntityToUserFunction implements Function<UserEntity, User> {

    @Override
    public User apply(UserEntity userEntity) {
        return null;
    }
}
