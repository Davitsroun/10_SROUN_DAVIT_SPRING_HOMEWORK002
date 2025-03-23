package org.example._10_sroun_davit_pvh_spring_homework002.Repositories;

import org.apache.ibatis.annotations.*;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Student;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Respone.StudentApiResponse;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.StudentResquest;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
public interface StudentRepository {

    @Select("""
            SELECT * FROM students
            offset #{size} * (#{page} -1)
            limit #{size}
            """)
    @Results(id = "StudentCourse", value = {
            @Result(property = "studentid", column = "student_id"),
            @Result(property = "courses",
                    column = "student_id",
                    many = @Many(select = "org.example._10_sroun_davit_pvh_spring_homework002.Repositories.CourseRepository.getCourseByStudentId"))
    })
    ArrayList<Student> getall(Integer size, Integer page);

    @Select("""
            SELECT  * FROM  students
            WHERE student_id= #{id} 
            """)
    @ResultMap("StudentCourse")
    Student getStusentByid(Integer id);


    @Select("""
            DELETE FROM students where student_id =#{id}
            """)
    Student deleteStudent(Integer id);


//    @Select("""
//            UPDATE studetns
//            SET student_name =#{request.student_name},
//                email =#{request.email},
//                phone_number= #{request.phone_number},
//                WHERE student_id = #{id}
//            RETURNING*
//            """)

    @Select("""
        UPDATE students set
              student_name = #{request.student_name}
             ,email = #{request.email}
             ,phone_number = #{request.phone_number}
        WHERE student_id = #{id}
    """)
    @ResultMap("StudentCourse")
    Student updateStudent(Integer id, @Param("request") StudentResquest studentResquest);


    @Select("""
                    INSERT INTO students (student_name, email ,phone_number) 
                    VALUES (#{request.student_name}, 
                            #{request.email}, 
                            #{request.phone_number})
                    RETURNING*
            """)
    @ResultMap("StudentCourse")
    Student insertStudent(@Param("request") StudentResquest studentResquest);

    @Select("""
        INSERT INTO student_course(student_id,course_id)
        values (#{studentId},#{courseId})
        """)
    void insertStudent_course(Integer studentId, Integer courseId);




//    deleted from middle table

    @Select("""
        DELETE FROM student_course
        WHERE student_id = #{studentId}
    """)
    void deleteStudentIdAndCourseId(Integer studentId);




}
