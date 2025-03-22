package org.example._10_sroun_davit_pvh_spring_homework002.Model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int course_id;
    private String course_name;
    private String description;
    private  Instructore instructore;

}
