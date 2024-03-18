package com.demo.springwebfluxdemo.dto;

import com.demo.springwebfluxdemo.model.metadata.CourseMetadata;

public record CourseDto(String name, String description, Integer duration, String teacher, CourseMetadata courseMetadata){
}
