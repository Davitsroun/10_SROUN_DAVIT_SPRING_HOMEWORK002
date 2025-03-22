package org.example._10_sroun_davit_pvh_spring_homework002.Service;

import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Course;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.CouseRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;



public interface CourseService {
    ArrayList<Course> getallStuCourse(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page);

    Course getCourseById(Integer id);

    Course isertCoures(CouseRequest isertCoures);

    Course deletCourse(Integer id);

    Course updateCourse(Integer id, CouseRequest isertCoures);
}
