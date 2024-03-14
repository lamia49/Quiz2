package com.example.quiz2.Controller;

import com.example.quiz2.Model.Students;
import com.example.quiz2.Service.StudentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentdsController {
    private final StudentsService studentsService;


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Students student , Errors error){
        if(error.hasErrors()){
            String massege=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        studentsService.add(student);
       return ResponseEntity.status(200).body("added");
    }

    @GetMapping("get")

    public ResponseEntity get(){
        return  ResponseEntity.status(200).body(studentsService.get());
    }

    @PutMapping("update/{id}")

    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid Students student ,Errors error){
        if(error.hasErrors()){
            String massge= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massge);
        }
        boolean isFound=studentsService.update(id,student);
        if(isFound) {
            return ResponseEntity.status(200).body("Updeated");
        } return ResponseEntity.status(400).body("not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound=studentsService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("Not Found");
    }


    @GetMapping("by_name/{name}")
    public ResponseEntity byname(@PathVariable String name){
        if(studentsService.byname(name)==null){
            return ResponseEntity.status(400).body("Not found");
        }

        return ResponseEntity.status(200).body(studentsService.byname(name));
    }



    @GetMapping("by_major/{major}")
    public ResponseEntity bymajor(@PathVariable String major){
        return  ResponseEntity.status(200).body(studentsService.bymajor(major));
    }
}
