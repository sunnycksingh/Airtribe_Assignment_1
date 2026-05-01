package com.airtribe.learntrack.entity;

public class Student extends Person
{
   private String batch;
   private boolean active;


    // Constructor

   public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
    super(id,firstName,lastName,email);
    this.batch = batch;
    this.active = active;
   }


   public String getBatch() {
    return batch;
   }


   public void setBatch(String batch) {
    this.batch = batch;
   }


   public boolean isActive() {
    return active;
   }


   public void setActive(boolean active) {
    this.active = active;
   }



   @Override
   public String toString() {
      return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", batch="
               + batch + ", active=" + active + "]";
   }


   @Override
   public void getDisplayName()
   {
      System.out.println("StudentName is :");
        System.out.println("FirstName is :"+" "+firstName);
        System.out.println("LastName is :"+" "+lastName);
   }





   

    
}