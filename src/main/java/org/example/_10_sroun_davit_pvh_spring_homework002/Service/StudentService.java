package org.example._10_sroun_davit_pvh_spring_homework002.Service;

import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Student;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.StudentResquest;

import java.util.ArrayList;

public interface StudentService {

    ArrayList<Student> getall(Integer size, Integer page);

    Student getStusentByid(Integer id);

    Student deleteStudent(Integer id);

    Student updateStudent(Integer id, StudentResquest studentResquest);

    Student insertStudent (StudentResquest studentResquest);
}
