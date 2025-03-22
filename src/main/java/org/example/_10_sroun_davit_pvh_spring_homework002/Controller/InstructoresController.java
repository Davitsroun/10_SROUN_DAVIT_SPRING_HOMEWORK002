package org.example._10_sroun_davit_pvh_spring_homework002.Controller;

import org.apache.ibatis.annotations.Delete;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.dto.Instructore;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Respone.InstructoresApiRespone;
import org.example._10_sroun_davit_pvh_spring_homework002.Model.entity.Resquest.InstructorRequest;
import org.example._10_sroun_davit_pvh_spring_homework002.Service.InstructorsSevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RemoteServer;
import java.time.LocalDateTime;
import java.util.ArrayList;



@RestController
@RequestMapping("/api/v1/instructores")
public class InstructoresController {
    private final InstructorsSevice instructorsSevice;

    public InstructoresController(InstructorsSevice instructorsSevice) {
        this.instructorsSevice = instructorsSevice;
    }

    @GetMapping
    public ResponseEntity<InstructoresApiRespone<ArrayList<Instructore>>> getAllInstructores(@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page){
        InstructoresApiRespone apiResponse = InstructoresApiRespone.<ArrayList<Instructore>>builder().
                message("All instuctors have been fetch successfully")
                .payload(instructorsSevice.getAllInstructors( size,  page))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
         return   ResponseEntity.status(201).body(apiResponse);
    }



    @PostMapping
    public ResponseEntity<InstructoresApiRespone<Instructore>> insertInstructor(@RequestBody InstructorRequest instructorRequest){
        InstructoresApiRespone apiResponse = InstructoresApiRespone.<Instructore>builder().
                message(" instuctors insert successfully")
                .payload(instructorsSevice.insertInstructor(instructorRequest))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
                return  ResponseEntity.status(201).body(apiResponse);

    }
    @GetMapping("/{id}")
    public  ResponseEntity<InstructoresApiRespone<Instructore>> selectInstructoreByID(@PathVariable Integer id){
        InstructoresApiRespone apiResponse = InstructoresApiRespone.<Instructore>builder().
                message("Select instuctors by id successfully")
                .payload(instructorsSevice.selectInstructorById(id))
                .status(HttpStatus.OK)
                .localDateTime(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(201).body(apiResponse);
    }


@DeleteMapping("/{id}")
    public ResponseEntity<InstructoresApiRespone> deleteInstructorById(@PathVariable Integer id){
        InstructoresApiRespone apiResponse = InstructoresApiRespone.<Instructore>builder().
                message("Delete instuctors id:"+id+" successfully")
                .status(HttpStatus.OK)
                .payload(instructorsSevice.deleteInstructorById(id))
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(apiResponse);
    }



    @PutMapping("/{id}")
    public ResponseEntity<InstructoresApiRespone<Instructore>> updateInstructore(@PathVariable Integer id , @RequestBody InstructorRequest instructorRequest){
        InstructoresApiRespone apiResponse = InstructoresApiRespone.<Instructore>builder().
                message(" instuctors Update successfully")
                .status(HttpStatus.OK)
                .payload(instructorsSevice.updateInstructore(id, instructorRequest))
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(apiResponse);
    }
}
