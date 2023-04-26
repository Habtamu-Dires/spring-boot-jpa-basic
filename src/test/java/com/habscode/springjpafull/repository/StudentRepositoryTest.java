package com.habscode.springjpafull.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.habscode.springjpafull.entity.Guardian;
import com.habscode.springjpafull.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
            .emailId("shabbir@gmail.com")
            .firstName("Shabbir")
            .lastName("Dawoodi")
            //.guardianName("Nikhil")
            //.guardianEmail("nikhil@gmail.com")
            //.guardianMbile("99999999999")
            .build();

        studentRepository.save(student);
    }

    Guardian guardian = Guardian.builder()
            .name("Nikhil")
            .email("nikhil@gmail.com")     
            .mobile("99999999999")
            .build();
    @Test
    public void saveStudentWithGuardian(){
        Student student = Student.builder()
            .firstName("Shivam")
            .emailId("shivam@gmail.com")
            .lastName("Kumar")
            .guardian(guardian)
            .build();

            studentRepository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<Student> studentsList = 
                studentRepository.findAll();
        
        System.out.println("studnetList " + studentsList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = 
            studentRepository.findByFirstNameContaining("Sh");
        
        System.out.println("students " + students);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = 
                studentRepository.findByGuardianName("Nikhil");
            
            System.out.println("student = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        Student student =
                studentRepository.findByFirstNameAndLastName("Shivam", "Kumar");
        
        System.out.println(student);

    }

    @Test
    public void printgetStudentByEmailAdress() {
        Student student =
                studentRepository.getStudentByEmailAdress(
                    "shabbir@gmail.com"
                );

            System.out.println("student " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAdress() {
        String fristName = 
             studentRepository.getStudentFirstNameByEmailAdress(
                "shabbir@gmail.com"
             );
        
        System.out.println("firstName " + fristName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = 
            studentRepository.getStudentByEmailAddressNative(
                "shabbir@gmail.com"
            );

        System.out.println("student: " + student);
    }
    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student = 
            studentRepository.getStudentByEmailAddressNativeNamedParam(
                "shabbir@gmail.com"
            );

        System.out.println("student: " + student); 
    } 

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
            "shabbir w",
             "shabbir@gmail.com"
            );
    }
}
