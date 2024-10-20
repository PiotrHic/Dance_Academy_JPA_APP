package com.example.dance_academy_jpa_app.service;

import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.repositories.DanceInstructorRepository;
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
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DanceInstructorServiceMockTest {

    @Mock
    DanceInstructorRepository danceInstructorRepository;

    AutoCloseable autoCloseable;
    @InjectMocks
    DanceInstructorServiceImpl danceInstructorService;

    DanceInstructor returned = DanceInstructor.builder()
            .name("test")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test1")
            .lastModifiedBy("test1")
            .yearsOfExperience(1)
            .build();

    DanceInstructor first = DanceInstructor.builder()
            .name("test1")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test")
            .lastModifiedBy("test")
            .yearsOfExperience(2)
            .build();

    DanceInstructor second = DanceInstructor.builder()
            .name("test2")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test2")
            .lastModifiedBy("test2")
            .yearsOfExperience(3)
            .build();


    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        danceInstructorService = new DanceInstructorServiceImpl(danceInstructorRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testMock(){
        Map mapMock = mock(Map.class);

        assertThat(mapMock.size()).isEqualTo(0);
    }


    @Test
    void createDanceInstructor(){

        //stub the data
        when(danceInstructorRepository.save(returned)).thenReturn(returned);

        DanceInstructor result = danceInstructorService.createDanceInstructor(returned);
        Assertions.assertEquals("test", result.getName());
    }

    @Disabled
    @Test
    public void getOneDanceInstructor() throws Exception{

        //stub the data
        when(danceInstructorRepository.getReferenceById(returned.getId())).thenReturn(returned);
        DanceInstructor result = danceInstructorService.getDanceInstructor(returned.getId());
        Assertions.assertEquals("test", result.getName());
    }

    @Test
    void getAllDanceInstructors(){
        // when
        when(danceInstructorRepository.findAll()).
                thenReturn(Arrays.asList(first,
                        second));

        //then
        List<DanceInstructor> danceInstructors = danceInstructorService.getAllDanceInstructors();
        Assertions.assertEquals(danceInstructors.size(), 2);
    }

    @Disabled
    @Test
    void updateDanceInstructor(){


        //stub the data
        when(danceInstructorRepository.getReferenceById(first.getId())).thenReturn(first);
        when(danceInstructorRepository.save(first)).thenReturn(first);

        danceInstructorService.createDanceInstructor(first);

        DanceInstructor result = danceInstructorService.updateDanceInstructor(second.getId(), second);
        Assertions.assertEquals("test2", result.getName());

    }

    @Disabled
    @Test
    void deleteDanceInstructor(){

        when(danceInstructorRepository.getReferenceById(returned.getId())).thenReturn(returned);
        String result = danceInstructorService.deleteDanceInstructor(returned.getId());
        Assertions.assertEquals(result, isNotNull());
    }
}
