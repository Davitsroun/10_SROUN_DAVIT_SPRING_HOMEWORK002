package org.example._10_sroun_davit_pvh_spring_homework002.Service.ServiceImp;

import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Student;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.StudentResquest;
import org.example._10_sroun_davit_pvh_spring_homework002.Repositories.StudentRepository;
import org.example._10_sroun_davit_pvh_spring_homework002.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentImp implements StudentService {

    private final StudentRepository studentRepository;

    public StudentImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public ArrayList<Student> getall(Integer size, Integer page) {
        return studentRepository.getall(size,page);
    }

    @Override
    public Student getStusentByid(Integer id) {
        return studentRepository.getStusentByid(id);
    }

    @Override
    public Student deleteStudent(Integer id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Student updateStudent(Integer id, StudentResquest studentResquest) {
        return studentRepository.updateStudent(id,studentResquest);
    }

    @Override
    public Student insertStudent(StudentResquest studentResquest) {
        Student student = studentRepository.insertStudent(studentResquest);
        for(Integer courseId :  studentResquest.getCourses()){
            studentRepository.insertStudent_course(student.getStudentid(),courseId);
        }
        return studentRepository.getStusentByid(student.getStudentid());
    }
}
