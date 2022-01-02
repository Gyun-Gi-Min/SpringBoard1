package org.example.springboard1.user;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard1.user.model.UserEntity;

@Mapper
public interface UserMapper {
    UserEntity selUser(UserEntity entity);
    int insUser(UserEntity entity);

}


