package org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Instructore;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouseRequest {
    private String course_name;
    private String description;
    private int instructor_id;
}
