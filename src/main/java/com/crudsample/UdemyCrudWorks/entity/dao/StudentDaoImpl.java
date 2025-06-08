package com.crudsample.UdemyCrudWorks.entity.dao;

import com.crudsample.UdemyCrudWorks.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao{

    //Define Field for entiry manager

    private EntityManager entityManager;

    //inject entity manager using constructor injection

    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student aStudent) {
        entityManager.persist(aStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }


}
