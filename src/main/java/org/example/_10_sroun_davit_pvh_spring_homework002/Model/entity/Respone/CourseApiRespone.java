package org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseApiRespone<T> {
    private String message;
    private  T payload;
    private HttpStatus status;
    private LocalDateTime localDateTime;

}
