package org.example._10_sroun_davit_pvh_spring_homework002.Repositories;

import org.apache.ibatis.annotations.*;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Instructore;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.InstructorRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.WebContentGenerator;

import java.util.ArrayList;

@Mapper
public interface InstructorsRepository {
    @Select("""
        SELECT * FROM  instructors
          offset #{size} * (#{page} -1)
   limit #{size}
        """)

    ArrayList<Instructore> getAllInstrctors( Integer size, Integer page);


    @Select("""
    INSERT INTO instructors(instructor_name, email) VALUES ( #{request.instructor_name}, #{request.email}) 
    RETURNING*  
    """)
    Instructore insertInstuctor(@Param("request") InstructorRequest instructorRequest);



    @Select("""
    SELECT * FROM instructors WHERE instructor_id = #{id}
  
    """)
    Instructore selectInstructoreByID(Integer id);



    @Select("""
    DELETE FROM instructors WHERE  instructor_id = #{id}
    """)
    Instructore deleteInstructorById(Integer id);


@Select("""
        UPDATE  instructors 
        SET instructor_name= #{request.instructor_name},
            email = #{request.email}
        WHERE instructor_id= #{courseId}
        RETURNING*
        """)
    Instructore updateInstructore (@Param("courseId")  Integer id,@Param("request") InstructorRequest instructorRequest);
}
