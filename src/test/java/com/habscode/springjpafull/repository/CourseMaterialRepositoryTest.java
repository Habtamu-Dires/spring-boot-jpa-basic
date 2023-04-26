package com.habscode.springjpafull.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.habscode.springjpafull.entity.Course;
import com.habscode.springjpafull.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {

        Course course = 
            Course.builder()
            .title(".net")
            .credit(6)
            .build();

        CourseMaterial courseMaterial = 
            CourseMaterial.builder()
            .url("wwww.dailyCodeBuffer.com")
            .course(course)
            .build();
        

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterials() {
        List <CourseMaterial> courseMaterial = 
         repository.findAll();

         System.out.println("courseMaterial " + courseMaterial);
    }

}
