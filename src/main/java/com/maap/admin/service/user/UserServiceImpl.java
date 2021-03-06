package com.maap.admin.service.user;

import com.maap.admin.domain.User;
import com.maap.admin.entity.UserEntity;
import com.maap.admin.function.JpaFunctions;
import com.maap.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User obj) {
        UserEntity userEntity = new UserEntity();
        userRepository.save(userEntity);
    }

    @Override
    public User update(UUID uuid, User objToUpdate) throws Exception {
        UserEntity userEntity = userRepository.findById(uuid).orElseThrow(() -> new Exception("User not found:" + uuid.toString()));
        //TODO: set values from new obj
        return JpaFunctions.userEntityToUserFunction.apply(userRepository.save(userEntity));
    }

    @Override
    public void deleteById(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(UserEntity::getId))
                .map(JpaFunctions.userEntityToUserFunction).collect(Collectors.toList());
    }

    @Override
    public User getBy(UUID uuid) throws Exception {
        return JpaFunctions.userEntityToUserFunction.apply(userRepository.findById(uuid).orElseThrow(() -> new Exception("User not found:")));
    }

}
