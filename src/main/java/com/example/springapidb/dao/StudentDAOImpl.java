package com.example.springapidb.dao;

import com.example.springapidb.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    // define field for entity manager
    private EntityManager entityManager;
    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
    // implement read method
    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create query
       TypedQuery<Student> theQueri = entityManager.createQuery("FROM Student order by lastName desc", Student.class);

         // return query results
       return theQueri.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        //set query parameter
        theQuery.setParameter("theData",theLastName);
        // return query
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
