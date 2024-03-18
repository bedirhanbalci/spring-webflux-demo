package com.demo.springwebfluxdemo.dto;

import java.util.List;

public record StudentDto(String name, String email, List<CourseDto> courses) {
}
