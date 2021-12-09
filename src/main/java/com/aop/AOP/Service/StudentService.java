package com.aop.AOP.Service;

import com.aop.AOP.Entity.Student;

import java.util.List;

public interface StudentService {

    public Student create(Student student);

    public List<Student> getAll();

    public Student getById(int id);

    public List<Student> delete(int id);

    public Student update(int id, Student student);
}
