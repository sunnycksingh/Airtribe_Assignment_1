package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;



public class EnrollmentService {

    ArrayList<Enrollment> enrollmentList = new ArrayList<>();

     private StudentService studentService;
     private CourseService  courseService;


     

     public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


   
     public void enrollStudent(int studentId, int courseId, String enrollmentDate)
     {

       try
    {

        Student student = studentService.getStudentId(studentId);

       if(!student.isActive())
       {
         System.out.println("Given student is not Active");
       }
     
      }
      catch(EntityNotFoundException ex)
    {
      System.out.println(ex.getMessage());
    }

    try
    {
         Course course = courseService.getCourseById(courseId);

      if(!course.isActive())
      {
         System.out.println("Given Course is not Active");
      }
    }
      catch(EntityNotFoundException ex)
    {
      System.out.println(ex.getMessage());
    }
    

        Enrollment enrollment = new Enrollment();
        enrollment.setId(IdGenerator.getNextEnrollId());
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        enrollment.setEnrollmentDate(enrollmentDate);
        enrollment.setStatus(EnrollmentStatus.ACTIVE);

        enrollmentList.add(enrollment);
     }

     public void viewEnrollmentStudent()
     {

      if(enrollmentList.isEmpty())
      {
         System.out.println("Currently no enrollment details are present");;
      }

      else
      {
           for(Enrollment e : enrollmentList)
        {

            {
            System.out.println("Id is : "+ ""+e.getId());
            System.out.println("Student Id : "+" "+e.getStudentId());
            System.out.println("Course Id is :"+" "+e.getCourseId());
            System.out.println("Enrollment date is :"+" "+e.getEnrollmentDate());
            System.out.println("Status is :"+" "+e.getStatus());
            System.out.println("----------------------------------");
            }
        }

      }

      

     }


     public void checkEnrollmentUpdated(int id, String statusInput) throws Exception
     {
      try
      {
            EnrollmentStatus status = EnrollmentStatus.valueOf(statusInput.toUpperCase());

       for(Enrollment e : enrollmentList)
         {
            if(e.getId() == id)
            {
               e.setStatus(status);
               System.out.println("Status Updated Successfully");
               return;
            }
         }
       throw new EntityNotFoundException("The given Enrollment Id is not present : "+id);
     }
     catch(IllegalArgumentException e)
     {
       System.out.println("Invalid status! Use: ACTIVE / COMPLETED / CANCELLED");
     }
   
   }

     
}    

