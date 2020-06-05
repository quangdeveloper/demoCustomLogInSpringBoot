package vn.devpro.jackson.service.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.devpro.jackson.model.Student;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl {

    public List<Student> findAll(){

        System.out.println("\n StudentServiceImpl \n");
        Student s1 = new Student(1L,"quang",19,"097777");
        Student s2 = new Student(2L,"thanh",19,"097777");
        Student s3 = new Student(3L,"thang",19,"097777");
        Student s4 = new Student(4L,"minh",19,"097777");

        List<Student> students = Arrays.asList(s1,s2,s3,s4);
        return students;
    }
}
