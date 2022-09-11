package com.springboot.miscroserice.course.repository;

import com.springboot.miscroserice.course.modal.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity,Integer> {
}