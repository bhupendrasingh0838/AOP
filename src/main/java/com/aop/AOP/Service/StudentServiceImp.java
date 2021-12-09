package com.aop.AOP.Service;

import com.aop.AOP.Annotation.CustomAnnotation;
import com.aop.AOP.Entity.Student;
import com.aop.AOP.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    @CustomAnnotation
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> delete(int id) {
        Student student = studentRepository.findById(id).orElseThrow(null);
        if (student.getId() == id) {
            studentRepository.deleteById(id);
        }
        return studentRepository.findAll();
    }

    @Override
    public Student update(int id, Student student) {
        Student student1 = studentRepository.findById(id).get();
        student1.setName(student.getName());
        student1.setAddress(student.getAddress());
        studentRepository.save(student1);
        return  student1;
    }
}
