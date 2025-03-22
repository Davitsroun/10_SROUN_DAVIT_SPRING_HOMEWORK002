package org.example._10_sroun_davit_pvh_spring_homework002.Service.ServiceImp;

import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Instructore;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.InstructorRequest;
import org.example._10_sroun_davit_pvh_spring_homework002.Repositories.InstructorsRepository;
import org.example._10_sroun_davit_pvh_spring_homework002.Service.InstructorsSevice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class InstructorsImp implements InstructorsSevice {

    private final InstructorsRepository instructorsRepository;

    public InstructorsImp(InstructorsRepository instructorsRepository) {
        this.instructorsRepository = instructorsRepository;
    }

    @Override
    public ArrayList<Instructore> getAllInstructors(Integer size, Integer page) {
        return instructorsRepository.getAllInstrctors(size,page);
    }

    @Override
    public Instructore insertInstructor(InstructorRequest instructorRequest) {
        return instructorsRepository.insertInstuctor(instructorRequest);
    }

    @Override
    public Instructore selectInstructorById(Integer id) {
        return instructorsRepository.selectInstructoreByID(id);
    }

    @Override
    public Instructore deleteInstructorById(Integer id) {
        return instructorsRepository.deleteInstructorById(id);
    }

    @Override
    public Instructore updateInstructore(Integer id, InstructorRequest instructorRequest) {
        return instructorsRepository.updateInstructore(id,instructorRequest);
    }
}
