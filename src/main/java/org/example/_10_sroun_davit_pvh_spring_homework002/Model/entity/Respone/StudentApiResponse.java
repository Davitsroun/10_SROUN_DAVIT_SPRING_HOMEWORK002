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
public class StudentApiResponse<T> {
    private String message;
    private HttpStatus status;
    private T payload;
    private LocalDateTime timestamp;
}
