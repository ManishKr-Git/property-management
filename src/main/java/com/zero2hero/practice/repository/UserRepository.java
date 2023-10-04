package com.zero2hero.practice.repository;

import com.zero2hero.practice.entity.PropertyEntity;
import com.zero2hero.practice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
