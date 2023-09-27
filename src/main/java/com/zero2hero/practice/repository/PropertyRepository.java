package com.zero2hero.practice.repository;

import com.zero2hero.practice.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
