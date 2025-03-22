package org.example._10_sroun_davit_pvh_spring_homework002.Controller;


import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Course;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Instructore;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Respone.CourseApiRespone;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Respone.InstructoresApiRespone;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.CouseRequest;
import org.example._10_sroun_davit_pvh_spring_homework002.Repositories.CourseRepository;
import org.example._10_sroun_davit_pvh_spring_homework002.Service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student_course")
public class CourseController {

    private final CourseService studentCourseService;

    public CourseController(CourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping
     public ResponseEntity<CourseApiRespone<ArrayList<Course>>> getAllStudent_course(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page){
        CourseApiRespone<ArrayList<Course>> apiResponse = CourseApiRespone.<ArrayList<Course>>builder().
                message("All course have been fetch successfully")
                .payload(studentCourseService.getallStuCourse(size,page))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
return ResponseEntity.status(201).body(apiResponse);
      //  return  studentCourseService.getallStuCourse(size, page);
    }

    @GetMapping("/{id}")
     public ResponseEntity<CourseApiRespone<Course>> getCourseById(@PathVariable Integer id){
        CourseApiRespone<Course> apiResponse = CourseApiRespone.<Course>builder().
                message("All course have been fetch successfully")
                .payload(studentCourseService.getCourseById(id))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(apiResponse);
    }


    @PostMapping
    public  ResponseEntity<CourseApiRespone<Course>> isertCoures(@RequestBody CouseRequest couseRequest){
        CourseApiRespone<Course> apiResponse = CourseApiRespone.<Course>builder().
                message("Update couse successfully")
                .payload(studentCourseService.isertCoures(couseRequest))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(apiResponse);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<CourseApiRespone<Course>> deletCourse ( @PathVariable Integer id) {
        CourseApiRespone<Course> apiResponse = CourseApiRespone.<Course>builder().
                message("Delete course successfully")
                .payload(studentCourseService.deletCourse(id))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(apiResponse);
    }


    @PutMapping ("/{id}")
    public  ResponseEntity<CourseApiRespone<Course>> updateCourse(@PathVariable Integer id, @RequestBody CouseRequest couseRequest){
        CourseApiRespone<Course> apiResponse = CourseApiRespone.<Course>builder().
                message("Updaate course successfully")
                .payload(studentCourseService.updateCourse(id,couseRequest))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(apiResponse);
    }
}
