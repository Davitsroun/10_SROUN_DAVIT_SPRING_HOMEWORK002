package org.example._10_sroun_davit_pvh_spring_homework002.Controller;


import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Student;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Respone.StudentApiResponse;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.StudentResquest;
import org.example._10_sroun_davit_pvh_spring_homework002.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<StudentApiResponse<ArrayList<Student>>> getall(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page){

        StudentApiResponse studentApiRespons= StudentApiResponse.<ArrayList<Student>>builder()
                .message("Get All Student Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.getall(size,page))
                .timestamp(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(201).body(studentApiRespons);
    }

    

    @GetMapping("/{id}")
    public   ResponseEntity<StudentApiResponse<Student>> getStusentByid( @PathVariable Integer id){

        StudentApiResponse studentApiRespons= StudentApiResponse.<Student>builder()
                .message("Get Student by id Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.getStusentByid(id))
                .timestamp(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(201).body(studentApiRespons);
    }



    @DeleteMapping("/{id}")
    public  ResponseEntity<StudentApiResponse<Student>>  deleteStudent(@PathVariable Integer id){
        StudentApiResponse studentApiRespons= StudentApiResponse.<Student>builder()
                .message("Delete  Student by id Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.deleteStudent(id))
                .timestamp(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(201).body(studentApiRespons);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<StudentApiResponse<Student>>  updateStudent(@PathVariable Integer id, @RequestBody StudentResquest studentResquest){
        StudentApiResponse studentApiRespons= StudentApiResponse.<Student>builder()
                .message("Update  Student by id Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.updateStudent(id,studentResquest))
                .timestamp(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(201).body(studentApiRespons);
    }

    @PostMapping
    public   ResponseEntity<StudentApiResponse<Student>>  insertStudent( @RequestBody StudentResquest studentResquest){
        System.out.println(studentResquest);

        StudentApiResponse studentApiRespons= StudentApiResponse.<Student>builder()
                .message("insert  Student Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.insertStudent(studentResquest))
                .timestamp(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(201).body(studentApiRespons);
    }


}
