package vn.devpro.jackson.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.devpro.jackson.dto.ResponseDto;
import vn.devpro.jackson.service.ServiceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<ResponseDto> getListStu() {
        System.out.println(" \nRest Controller ís run \n");
        return ResponseEntity.ok().body(
                ResponseDto.builder()
                        .code("200")
                        .message("Successful")
                        .value(studentService.findAll())
                        .build()
        );


    }
}
