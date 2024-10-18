package com.example.dance_academy_jpa_app.service;


import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.repositories.CourseTopicRepository;
import com.example.dance_academy_jpa_app.repositories.DanceInstructorRepository;
import com.example.dance_academy_jpa_app.service.courseTopic.CourseTopicServiceImpl;
import com.example.dance_academy_jpa_app.service.danceInstructor.DanceInstructorServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseTopicServiceMockTest {

    @Mock
    CourseTopicRepository courseTopicRepository;

    AutoCloseable autoCloseable;

    @InjectMocks
    CourseTopicServiceImpl courseTopicService;

    CourseTopic returned = CourseTopic.builder()
                    .name("test1")
                    .createdAt(LocalDateTime.now())
                    .lastModifiedAt(LocalDateTime.now())
                    .createdBy("test1")
                    .lastModifiedBy("test1")
                    .build();

    CourseTopic first = CourseTopic.builder()
                    .name("test2")
                    .createdAt(LocalDateTime.now())
                    .lastModifiedAt(LocalDateTime.now())
                    .createdBy("test2")
                    .lastModifiedBy("test2")
                    .build();

    CourseTopic second = CourseTopic.builder()
                    .name("test3")
                    .createdAt(LocalDateTime.now())
                    .lastModifiedAt(LocalDateTime.now())
                    .createdBy("test3")
                    .lastModifiedBy("test3")
                    .build();

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        courseTopicService = new CourseTopicServiceImpl(courseTopicRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void createCourseTopic(){

        //stub the data
        when(courseTopicRepository.save(returned)).thenReturn(returned);

        CourseTopic result = courseTopicService.createTopic(returned);
        Assertions.assertEquals("test1", result.getName());
    }

    @Disabled
    @Test
    public void getOneCourseTopic() throws Exception{

        //stub the data
        when(courseTopicRepository.getReferenceById(returned.getId())).thenReturn(returned);
        CourseTopic result = courseTopicService.getCourseTopic(returned.getId());
        Assertions.assertEquals("test", result.getName());
    }
    @Test
    void getAllCourseTopics(){
        // when
        when(courseTopicRepository.findAll()).
                thenReturn(Arrays.asList(first,
                        second));

        //then
        List<CourseTopic> courseTopics = courseTopicService.getAllCourseTopics();
        Assertions.assertEquals(courseTopics.size(), 2);
    }
    @Disabled
    @Test
    void updateCourseTopic(){


        //stub the data
        when(courseTopicRepository.getReferenceById(first.getId())).thenReturn(first);
        when(courseTopicRepository.save(first)).thenReturn(first);

        courseTopicService.createTopic(first);

        CourseTopic result = courseTopicService.updateCourseTopic(second.getId(), second);
        Assertions.assertEquals("test2", result.getName());

    }

    @Disabled
    @Test
    void deleteCourseTopic(){

        when(courseTopicRepository.getReferenceById(returned.getId())).thenReturn(returned);
        String result = courseTopicService.deleteCourseTopicByID(returned.getId());
        Assertions.assertEquals(result, isNotNull());
    }


}
