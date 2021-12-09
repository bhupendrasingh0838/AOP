package com.aop.AOP.Controller;

import com.aop.AOP.Entity.Student;
import com.aop.AOP.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student student){
       return studentService.create(student);
    }
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping("/getById/{id}")
    public  Student getById(@PathVariable int id){
        return studentService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public List<Student> delete(@PathVariable int id){
       return studentService.delete(id);

    }
}
