package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Student;

import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService 
{

    ArrayList<Student> studentList = new ArrayList<>();

    // Methods creation 

    public void addStudent(Student s)
    {
        studentList.add(s);
        System.out.println("Recorder Added Successfully");

    }

    public void viewAllStudents()
    {
       if(studentList.isEmpty())
       {
        System.out.println("No Student Found");
         return;
       }
        
     else
     {
       System.out.println("----- Student List -----");
       for(Student s : studentList)
       {
        System.out.println("Id is : "+ ""+s.getId());
        System.out.println("FirstName is : "+" "+s.getFirstName()+" "+"LastName is :"+" "+s.getLastName());
        System.out.println("Email is :"+" "+s.getEmail());
        System.out.println("Batch is :"+" "+s.getBatch());
        System.out.println("Status is :"+" "+s.isActive());
        System.out.println("----------------------------------");
       }
     }
     
    }

    public void searchStudentById(int id) throws EntityNotFoundException
    {
      boolean flag = false;
        for(Student s : studentList)
        {
          if(s.getId() == id)
          {
            flag = true;
            System.out.println("Id is : "+ ""+s.getId());
            System.out.println("FirstName is : "+" "+s.getFirstName()+" "+"LastName is :"+" "+s.getLastName());
            System.out.println("Email is :"+" "+s.getEmail());
            System.out.println("Batch is :"+" "+s.getBatch());
            System.out.println("Status is :"+" "+s.isActive());
          }
           
        }
        if(!flag)
        {
          throw new EntityNotFoundException("Student not found with id searchStudentById : " + id);
        }
          
        
    }

    public void deactiveStudent(int id) throws Exception
    {
      boolean flag = false;

         for(Student s : studentList)
        {
            if(s.getId() == id)
          {
            flag = true;
              if(!s.isActive())
              {
                throw new Exception("Student is already In-Active");
              }
          
            s.setActive(false);
            System.out.println("We have successfully In-Active the Student");
          }
        }

        if(!flag)
        {
          throw new EntityNotFoundException("Student not found with id deactiveStudent: " + id);
        }
    
    }

    public Student getStudentId(int id) throws EntityNotFoundException
    {

      for(Student s : studentList)
      {
        if(s.getId() == id)
        {
          return s;
        }
      }

      throw new EntityNotFoundException("Student not found with id getStudentId: " + id);
      
    }

    public boolean isActiveStudent(int id) throws EntityNotFoundException
    {
      for(Student s : studentList)
      {
        if(s.getId()== id)
        {
          return s.isActive();
        }
      }
      
      throw new EntityNotFoundException("Student not found with id isActiveStudent : " + id);
    }

}
