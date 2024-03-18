package com.demo.springwebfluxdemo.repository;

import com.demo.springwebfluxdemo.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface StudentRepository extends ReactiveCrudRepository<Student, UUID> {
}
