package org.example._10_sroun_davit_pvh_spring_homework002.Service.ServiceImp;

import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Course;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.CouseRequest;
import org.example._10_sroun_davit_pvh_spring_homework002.Repositories.CourseRepository;
import org.example._10_sroun_davit_pvh_spring_homework002.Service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Service
public class CourseImp implements CourseService {

    private final CourseRepository studentCourseRepository;

    public CourseImp(CourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public ArrayList<Course> getallStuCourse(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page) {
        return studentCourseRepository.getAllStudent_course();
    }

    @Override
    public Course getCourseById(Integer id) {
        return studentCourseRepository.getCourseById(id);
    }

    @Override
    public Course isertCoures(CouseRequest couseRequest) {
        return studentCourseRepository.isertCoures(couseRequest);
    }

    @Override
    public Course deletCourse(Integer id) {
        return studentCourseRepository.deleteCourse(id);
    }

    @Override
    public Course updateCourse(Integer id, CouseRequest couseRequest) {
        return studentCourseRepository.updateCourse(id, couseRequest);
    }
}
