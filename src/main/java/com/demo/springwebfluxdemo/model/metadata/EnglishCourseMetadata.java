package com.demo.springwebfluxdemo.model.metadata;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class EnglishCourseMetadata extends CourseMetadata {

    private String level;

    private List<String> books;

}
