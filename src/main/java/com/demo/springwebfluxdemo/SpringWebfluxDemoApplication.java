package com.demo.springwebfluxdemo;

import com.demo.springwebfluxdemo.model.Course;
import com.demo.springwebfluxdemo.model.Student;
import com.demo.springwebfluxdemo.model.metadata.EnglishCourseMetadata;
import com.demo.springwebfluxdemo.model.metadata.SpringCourseMetadata;
import com.demo.springwebfluxdemo.repository.CourseRepository;
import com.demo.springwebfluxdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class SpringWebfluxDemoApplication implements CommandLineRunner {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    public SpringWebfluxDemoApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Course course = Course.builder()
                .id(UUID.randomUUID())
                .name("Webflux")
                .description("Spring Webflux")
                .duration(10)
                .teacher("Bedirhan")
                .courseMetadata(SpringCourseMetadata.builder()
                        .type("spring")
                        .language("Java")
                        .github("https://github.com/bedirhanbalci")
                        .prerequisites(List.of("Java", "Spring"))
                        .build())
                .isUpdated(false)
                .build();

        courseRepository.save(course).block();

        Student student = Student.builder()
                .id(UUID.randomUUID())
                .name("John")
                .email("john@mail.com")
                .dateOfBirth(LocalDate.of(1999, 1, 1))
                .courses(Set.of(course.getId().toString()))
                .isUpdated(false)
                .build();

        studentRepository.save(student).block();

        Course course2 = Course.builder()
                .id(UUID.randomUUID())
                .name("English")
                .description("English with Bedirhan")
                .duration(100)
                .teacher("Bedirhan")
                .courseMetadata(EnglishCourseMetadata.builder()
                        .type("spring")
                        .level("B2")
                        .books(List.of("B1", "B2"))
                        .build())
                .isUpdated(false)
                .build();

        courseRepository.save(course2).block();

        Student student2 = Student.builder()
                .id(UUID.randomUUID())
                .name("Doe")
                .email("doe@mail.com")
                .dateOfBirth(LocalDate.of(2000, 1, 1))
                .courses(Set.of(course2.getId().toString()))
                .isUpdated(false)
                .build();

        studentRepository.save(student2).block();
    }
}
