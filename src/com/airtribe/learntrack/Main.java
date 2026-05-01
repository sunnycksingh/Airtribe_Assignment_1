package com.airtribe.learntrack;

import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;


public class Main 
{

    public static void callStudentMangement(Scanner sc,StudentService service)
    {

      Student s;

        while(true)
        {

        int studentChoice = 0; 

        System.out.println("1. Add New Student");
        System.out.println("2. View all Student");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactiviate the Student");
        System.out.println("5. Back");

        try
        {
            studentChoice = sc.nextInt();
        }
        catch(Exception ex)
        {
            System.out.println("Please Enter Proper Student Choice");
            sc.nextLine();
            continue;
        }

        switch(studentChoice)
        {
            case 1 : 
            // call add method
            sc.nextLine();
            String firstName;
            while(true)
            {
               System.out.println("Enter your FirstName");
               firstName =  sc.nextLine();
               if(firstName.isEmpty())
               {
                System.out.println("FirstName cannot be empty");
               }
               else if (!firstName.matches("[a-zA-Z]+"))
               {
                System.out.println("FirstName contain only Alphabhets");
               }
               else
               {
                break;
               }
            }
               String lastName;
               while(true)
               {
                 System.out.println("Enter your LastName");
                 lastName = sc.nextLine();
                 if(lastName.isEmpty())
                {
                    System.out.println("lastName cannot be empty");
                }
               else if (!lastName.matches("[a-zA-Z]+"))
                {
                    System.out.println("lastName contain only Alphabhets");
                }
               else
               {
                break;
               }
            }
    
            String email;
            while(true)
            {
                System.out.println("Enter your Email");
                 email = sc.nextLine();
                System.out.println("Enter your Batch");

                if(email.isEmpty())
                {
                    System.out.println("Email cannot be Empty");
                }
                else if(!email.contains("@") || !email.endsWith(".com"))
                {
                  System.out.println("Email must contain @ and .com");
                }
                else
                {
                    break;
                }
            }

            String batch;
            while(true)
                {
                    System.out.println("Please Enter Batch Name");
                    batch = sc.nextLine();
                    if(batch.isEmpty())
                    {
                        System.out.println("Batch cannot be Empty");
                    }
                    else 
                    {
                        break;
                    }
                } 

  
            s = new Student(IdGenerator.getNextStudentId(),firstName,lastName,email,batch,true);
            service.addStudent(s);
            break;

            case 2: 
                   service.viewAllStudents();
            break;

            case 3 : 
            // call Search method
            try{

                System.out.println("Enter Student Id");
                int searchId = sc.nextInt();
                service.searchStudentById(searchId);
            }
            catch(EntityNotFoundException ex)
            {
                System.out.println(ex.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Input Mismatch");
                sc.nextLine();
                continue;
            }


            break;

            case 4 : 
            try
            {
               System.out.println("Enter Student Id to be De-activated");
               int deactiveId = sc.nextInt();
               service.deactiveStudent(deactiveId);
            }
              catch(Exception e)
            {
                System.out.println("Input Mismatch");
                sc.nextLine();
                continue;
            }
          
            break;

            case 5 : 
            return;

            default : System.out.println("Invalid"); 
            break;

        }
    }
    
    }
         public static void callCourseMangement(Scanner sc,CourseService courseService)
    {

        Course c;
        while(true)
        {

        int courseChoice = 0; 

        System.out.println("1. Add New Course");
        System.out.println("2. View all Course");
        System.out.println("3. Activae/Deactivate Course");
        System.out.println("4. Back");

        try
        {
          courseChoice = sc.nextInt();
        }
        catch(Exception ex)
        {
            System.out.println("Please Enter Proper Course Choice");
            sc.nextLine();
            continue;
        }
        

        switch(courseChoice)
        {
            case 1 : 
                    sc.nextLine();
                    try
                    {
                           
                        System.out.println("1. Enter your Course Name : ");
                        String coursename = sc.nextLine();
                        System.out.println("Enter Course Description");
                        String courseDescription = sc.nextLine();
                        System.out.println("Enter Duration in Weeks");
                        double durationWeek = sc.nextDouble();
                        c = new Course(IdGenerator.getNextCourseId(), coursename, courseDescription, durationWeek, true);
                        courseService.addCourse(c);
                    }
                       catch(Exception e)
                    {
                        System.out.println("Input Mismatch");
                        sc.nextLine();
                        continue;
                    }
            break;

            case 2: 
           
                   courseService.viewAllCourses();
                 
            break;

            case 3 : 
            
                     try
                     {
                       System.out.println("Enter Course Id to be De-activated/Activated");
                       int courseDeactiveId = sc.nextInt();
                       courseService.deactivateCourse(courseDeactiveId);
                     }
                        catch(Exception e)
                    {
                        System.out.println("Input Mismatch");
                        sc.nextLine();
                        continue;
                    }
                     
                
            break;

            case 4 : 
            return;

            default : System.out.println("Invalid"); 
            break;

        }
    }
    }

         public static void callEnrollmentMangement(Scanner sc, EnrollmentService enrollmentService)
    {

        while(true)
        {


        int enrollmentChoice = 0; 

        System.out.println("1. Enroll a student in course");
        System.out.println("2. View Enrollment for a Student");
        System.out.println("3. Mark Enrollment as Completed/Cancelled");
        System.out.println("4. Back");

        try
        {

          enrollmentChoice = sc.nextInt();
        }
        catch(Exception ex)
        {
            System.out.println("Please Enter Proper Enrollment Choice");
            sc.nextLine();
            continue;
        }
        

        switch(enrollmentChoice)
        {
            case 1 : 
                     sc.nextLine();
                     try
                     {
                        System.out.println("Enter your Student Id");
                        int studentId = sc.nextInt();
                        System.out.println("Enter your Course Id");
                        int courseId = sc.nextInt();
                        System.out.println("Enter Enrollment Date");
                        String enrollmentDate = sc.next();
                        enrollmentService.enrollStudent(studentId, courseId,enrollmentDate);  
                     }  
                         catch(Exception e)
                    {
                        System.out.println("Input Mismatch");
                        sc.nextLine();
                        continue;
                    }
                    break;

            case 2: 
                    enrollmentService.viewEnrollmentStudent();
            break;

            case 3 : 
                    
                 try
                 {
                    System.out.println("Enter your Enrollment Id");
                    int id = sc.nextInt();
                    System.out.println("Please Enter your Status");
                    String status = sc.next();
                    enrollmentService.checkEnrollmentUpdated(id, status);
                 }
                    catch(Exception e)
                    {
                        System.out.println("Input Mismatch");
                        sc.nextLine();
                        continue;
                    }
                  
                   break;

            case 4 : 

            return;


            default : System.out.println("Invalid"); 
            break;

        }

    }

    }

    public static void main(String[] args) 
    {
          StudentService studentService = new StudentService();
          CourseService  courseService  = new CourseService();
          EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int choice = 0;


        while(!flag)
        {
            System.out.println("----- Menu List -----");
            System.out.println("1. Student Mangement");
            System.out.println("2. Cousre Mangement");
            System.out.println("3. Enrollment Mangement");
            System.out.println("4. Exit");
            System.out.println("Enter your Choice");

            try
            {
             choice = sc.nextInt();
            }
            catch(Exception ex)
            {
                System.out.println("Please enter proper chocie");
                sc.nextLine();
                continue;
            }
            
            switch(choice)
            {
                case 1 : callStudentMangement(sc,studentService);
                break;

                 case 2 : callCourseMangement(sc,courseService);
                 break;

                 case 3 : callEnrollmentMangement(sc,enrollmentService);
                 break;

                 case 4 : flag = true;
                 break;

                 default : System.out.println("You have not entered the correct value");
                 break;
            }
    }


    }
    
}
