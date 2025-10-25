package com.crudsample.UdemyCrudWorks.entity.dao;

import com.crudsample.UdemyCrudWorks.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student aStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
