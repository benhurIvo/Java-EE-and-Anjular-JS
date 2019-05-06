/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivo.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ivo.dao.StudentDao;
import com.ivo.model.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author benhur
 */
@Stateless
@ApplicationPath("/resources")
@Path("school")
public class SchoolResource extends Application {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getPersonsBrowser() {
        System.out.println("Getting list of people...");
        List<Student> students = StudentDao.getAll();
        System.out.println("data out "+students);
        return students;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> saveStudent(String data) {
        System.out.println("data "+data);
        Gson gson=new GsonBuilder().create();
    
        Student st=gson.fromJson(data,Student.class);      
        StudentDao.saveStudent(st);
        List<Student> students = StudentDao.getAll();
        System.out.println("data out "+students);
        return students;
    }
    
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> delStudent(@PathParam("id") int id) {
        System.out.println("data ivo "+id); 
        Student st = new Student();
        st.setSId(id);
        st.setDob("");
        st.setFName("");
        st.setLName("");
        StudentDao.removeStudent(st);
        List<Student> students = StudentDao.getAll();
        System.out.println("data out "+students);
        return students;
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> updateStudent(String data) {
        System.out.println("data "+data);
        Gson gson=new GsonBuilder().create();
    
        Student st=gson.fromJson(data,Student.class);      
        StudentDao.updateStudent(st);
        List<Student> students = StudentDao.getAll();
        System.out.println("data out "+students);
        return students;
    }
}
