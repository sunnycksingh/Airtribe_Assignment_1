package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {
    
    ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(Course c)
    {
        courseList.add(c);
    }

    public void viewAllCourses()
    {
        if(courseList.isEmpty())
            System.out.println("No Course Currenlty Presnet");

        else
        {

            for(Course c : courseList)
            {
            System.out.println("Id is : "+ ""+c.getId());
            System.out.println("CourseName is : "+" "+c.getCousreName());
            System.out.println("Course Description is :"+" "+c.getDescription());
            System.out.println("Duration is :"+" "+c.getDurationInWeeks());
            System.out.println("Status is :"+" "+c.isActive());
            System.out.println("----------------------------------");
            }
       }

        
    }

    public void deactivateCourse(int id) throws Exception
    {
       
        for(Course c : courseList)
        {
            if(c.getId() == id)
            {
                
              if(c.isActive())
              {
                c.setActive(false);
                System.out.println("Course has been Deactivated Successfully from given Id : "+id);
              }
              else
              {
                c.setActive(true);
                System.out.println("Course has been Activated Successfully from given Id : "+id);
              }
              return;
            
            }
        }
       
         throw new EntityNotFoundException("Course not found with the given Id "+ id);  
       
    }

    public Course getCourseById(int id) throws EntityNotFoundException
    {

        for(Course c : courseList)
        {
            if(c.getId() == id)
            {

                return c;
            }
        }

        throw new EntityNotFoundException("Course not found with the given Id "+ id);
        
    }

    public boolean isActiveCourse(int id) throws EntityNotFoundException
    {
        for(Course c : courseList)
        {
            if(c.getId() == id )
            {
                return c.isActive();
            }
        }

        throw new EntityNotFoundException("Course not found with the given Id "+ id);
    }

}


