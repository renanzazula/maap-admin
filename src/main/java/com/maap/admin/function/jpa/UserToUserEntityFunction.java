package com.maap.admin.function.jpa;

import com.maap.admin.domain.User;
import com.maap.admin.entity.UserEntity;

import java.util.function.Function;

public class UserToUserEntityFunction implements Function<User, UserEntity> {

    @Override
    public UserEntity apply(User input) {
        UserEntity output = new UserEntity();
        output.setId(input.getId());
        output.setName(input.getName());
        return output;
    }
}
