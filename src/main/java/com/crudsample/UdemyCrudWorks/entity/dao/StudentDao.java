package com.crudsample.UdemyCrudWorks.entity.dao;

import com.crudsample.UdemyCrudWorks.entity.Student;

public interface StudentDao {

    void save(Student aStudent);

    Student findById(Integer id);
}
