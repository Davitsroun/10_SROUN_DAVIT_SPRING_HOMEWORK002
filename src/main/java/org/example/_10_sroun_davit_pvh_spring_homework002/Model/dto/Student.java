package org.example._10_sroun_davit_pvh_spring_homework002.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentid;
    private String student_name;
    private String email;
    private String phone_number;
    private ArrayList<Course>  courses;

}
