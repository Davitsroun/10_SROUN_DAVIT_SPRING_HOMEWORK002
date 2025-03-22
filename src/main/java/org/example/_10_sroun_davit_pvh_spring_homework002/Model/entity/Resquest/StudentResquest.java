package org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Course;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResquest {
    private String student_name;
    private String email;
    private int phone_number;
    private List<Integer> courses;
}
