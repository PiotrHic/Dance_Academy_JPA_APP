package com.example.dance_academy_jpa_app.repository;

import com.example.dance_academy_jpa_app.domain.CourseTopic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CourseTopicRepositoryTests {

    @Autowired
    CourseTopicRepository courseTopicRepository;

    CourseTopic first = CourseTopic.builder()
            .name("test1")
            .createdAt(LocalDateTime.MIN)
            .lastModifiedAt(LocalDateTime.MIN)
            .createdBy("test1")
            .lastModifiedBy("test1")
            .build();

    CourseTopic second = CourseTopic.builder()
            .name("test2")
            .createdAt(LocalDateTime.MAX)
            .lastModifiedAt(LocalDateTime.MAX)
            .createdBy("test2")
            .lastModifiedBy("test2")
            .build();

    @BeforeEach
    void setUp(){
        courseTopicRepository.deleteAll();
    }

    @Test
    void createCourseTopic(){

        long count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);

        courseTopicRepository.save(first);

        count = courseTopicRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void getAllCourseTopics(){

        long count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);

        courseTopicRepository.save(first);
        courseTopicRepository.save(second);

        count = courseTopicRepository.findAll().size();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void getOneDanceCourseById(){

        long count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);

        CourseTopic saved = courseTopicRepository.save(first);

        count = courseTopicRepository.count();

        assertThat(count).isEqualTo(1);

        CourseTopic founded = courseTopicRepository.getReferenceById(first.getId());

        assertThat(founded.getName()).isEqualTo("test1");

    }

    @Test
    void deleteCourseTopicById(){

        long count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);

        courseTopicRepository.save(first);

        count = courseTopicRepository.count();

        assertThat(count).isEqualTo(1);

        courseTopicRepository.deleteById(first.getId());

        count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);
    }

    @Test
    void deleteAllDanceCoursesId() {
        long count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);

        courseTopicRepository.save(first);
        courseTopicRepository.save(second);

        count = courseTopicRepository.count();

        assertThat(count).isEqualTo(2);

        courseTopicRepository.deleteAll();

        count = courseTopicRepository.count();

        assertThat(count).isEqualTo(0);

    }

}
