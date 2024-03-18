package com.demo.springwebfluxdemo.repository;

import com.demo.springwebfluxdemo.model.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CourseRepository extends ReactiveCrudRepository<Course, UUID> {
}
