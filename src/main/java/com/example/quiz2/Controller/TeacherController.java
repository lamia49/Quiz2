package com.example.quiz2.Controller;

import com.example.quiz2.Model.Students;
import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    TeacherService teacherService;


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        teacherService.add(teacher);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(teacherService.get());
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable int id ,@RequestBody @Valid Teacher teachers ,Errors error){
        if(error.hasErrors()){
            String massege=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isFound= teacherService.update(id,teachers);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("Not Found");
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id ){
        boolean isFound=teacherService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }

    @GetMapping("/{salary}")

    public ResponseEntity bysalary(@PathVariable int salary){
        return ResponseEntity.status(200).body(teacherService.bySalary(salary));
    }

}
