package org.example._10_sroun_davit_pvh_spring_homework002.Repositories;


import org.apache.ibatis.annotations.*;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Course;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.CouseRequest;

import java.util.ArrayList;

@Mapper
public interface CourseRepository {

    @Select("""
     SELECT * FROM courses 
    """)
    @Results( id="coure" , value = {
            @Result(property = "instructore" , column = "instructor_id" ,
                    one = @One( select = "org.example._10_sroun_davit_pvh_spring_homework002.Repositories.InstructorsRepository.selectInstructoreByID"))

    })
    ArrayList<Course> getAllStudent_course();

    @Select("""
        SELECT * FROM  courses WHERE course_id = #{id}    
        """)
    @ResultMap("coure")
    Course getCourseById(Integer id);


    @Select("""
       INSERT INTO courses(course_name, description,instructor_id) values 
                 (#{request.course_name},#{request.description},#{request.instructor_id})
       RETURNING*
        """)
    @ResultMap("coure")
    Course isertCoures(@Param("request") CouseRequest couseRequest);




    @Select("""
    DELETE FROM  courses where course_id =#{id}
    """)
    Course deleteCourse(Integer id);


    @Select("""
       UPDATE courses
       set
             course_name=#{request.course_name}, 
             description= #{request.description},
            instructor_id=#{request.instructor_id}              
       WHERE course_id=#{courseId}
       RETURNING*
                          
        """)
    @ResultMap("coure")
    Course updateCourse(@Param("courseId") Integer courseId , @Param("request") CouseRequest couseRequest );
}
