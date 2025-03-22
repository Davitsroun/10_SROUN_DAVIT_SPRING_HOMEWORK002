package org.example._10_sroun_davit_pvh_spring_homework002.Service;

import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Instructore;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.InstructorRequest;
import org.example._10_sroun_davit_pvh_spring_homework002.Repositories.InstructorsRepository;

import java.util.ArrayList;

public interface InstructorsSevice {

    ArrayList<Instructore> getAllInstructors(Integer size, Integer page);

    Instructore insertInstructor(InstructorRequest instructorRequest);

    Instructore selectInstructorById( Integer id);

    Instructore deleteInstructorById(Integer id);

    Instructore updateInstructore(Integer id , InstructorRequest instructorRequest);


}
