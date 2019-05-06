/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivo.dao;

import com.ivo.model.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author benhur
 */
public class StudentDao {
    public static Student getStudentById(int sId) {
        EntityManager em = ManagerDao.instance.createEntityManager();
        Student p = em.find(Student.class, sId);
        ManagerDao.instance.closeConnections(em);
        return p;
    }

    public static List<Student> getAll() {
        EntityManager em = ManagerDao.instance.createEntityManager();
        List<Student> list = em.createQuery("SELECT s From Student s")
            .getResultList();
        ManagerDao.instance.closeConnections(em);
        return list;
    }

    public static Student saveStudent(Student s) {
        EntityManager em = ManagerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(s);
        tx.commit();
        ManagerDao.instance.closeConnections(em);
        return s;
    } 

    public static Student updateStudent(Student s) {
        EntityManager em = ManagerDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        s=em.merge(s);
        tx.commit();
        ManagerDao.instance.closeConnections(em);
        return s;
    }

    public static void removeStudent(Student s) {
        EntityManager em = ManagerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        s=em.merge(s);
        em.remove(s);
        tx.commit();
        ManagerDao.instance.closeConnections(em);
    }
}
