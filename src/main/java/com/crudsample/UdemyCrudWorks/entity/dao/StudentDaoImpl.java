package com.crudsample.UdemyCrudWorks.entity.dao;

import com.crudsample.UdemyCrudWorks.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        String normalQuery = "From Student";
        String sqlQueryLastNameDesc = "From Student order by lastName desc";
        String sqlQueryLastNameasc= "From Student order by lastName asc";
        TypedQuery<Student> sqlQuery = entityManager.createQuery(normalQuery,Student.class);
        return sqlQuery.getResultList();/*.stream()
                .sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));*/
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        String normalQuery = "From Student where lastName=:theDate";

        TypedQuery<Student> sqlQuery = entityManager.createQuery(normalQuery,Student.class);
        sqlQuery.setParameter("theDate",theLastName);
        return sqlQuery.getResultList();
    }


}
