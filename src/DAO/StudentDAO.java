/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.*;
import Model.Crud;
/**
 *
 * @author Kebean
 */
public class StudentDAO {
    String url = "jdbc:postgresql://localhost:5432/Crud";
    String username = "postgres";
    String password = "kebean";
    public String createStudent(Crud studentObj){
        try{
            Connection Con = DriverManager.getConnection(url, username, password);
            String query = "insert into student (stid, student_names) values(?, ?)";
            PreparedStatement st = Con.prepareStatement(query);
            st.setInt(1, studentObj.getStid());
            st.setString(2, studentObj.getStudent_names());
            int rowsAffected = st.executeUpdate();
            Con.close();
            if(rowsAffected > 0){
                return "Student Registered Succesfully";
            }else{
                return "Fatal Error, Student Registration failed";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "Server Error";
    }
    public String updateStudent(Crud studentObj){
        try{
            Connection Con = DriverManager.getConnection(url, username, password);
            String query = "update student set student_names=? where stid=?";
            PreparedStatement st = Con.prepareStatement(query);
            st.setString(1, studentObj.getStudent_names());
            st.setInt(2, studentObj.getStid());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                return "Student Updated Succesfully";
            }else{
                return "Fatal Error, Updation failed";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "Server Error";
    }
    public String deleteStudent(Crud studentOb){
        try{
            Connection Con = DriverManager.getConnection(url, username, password);
            String query = "delete from student where stid=?";
            PreparedStatement st = Con.prepareStatement(query);
            st.setInt(1, studentOb.getStid());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0){
                return "Student Deleted Succesfully";
            }else{
                return "Fatal Error, student Deletion failed";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "Server Error";
    }
    // need to check how to implement a search function using a Student object as a return type
    public String searchStudent(Crud studentObj){
        try{
            Connection Con = DriverManager.getConnection(url, username, password);
            String query = "select * from student where stid=?";
            PreparedStatement st = Con.prepareStatement(query);
            st.setInt(1, studentObj.getStid());
            ResultSet result = st.executeQuery();
            if(result.next()){
                System.out.println("Student Exists, Here is His/Her name: ");
                System.out.println("Names: " + result.getString("student_names"));
                return "Student Searching succesfully completed";
            }else{
                return "Fatal Error, Student Searchiing failed";
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
                
        }
        return "Server Error";
    }
    // creating a method of List return type to hold all rows from the DB
   public List<Crud> allStudent(){
       try{
           Connection Con = DriverManager.getConnection(url, username, password);
           String query = "select * from student";
           PreparedStatement st = Con.prepareStatement(query);
           ResultSet result = st.executeQuery();
           // Creating studentList variable of type List with student object(Crud) as generic.
           List<Crud> studentList = new ArrayList<>();
           while(result.next()){
               Crud studentObj = new Crud();
               studentObj.setStid(result.getInt(0));
               studentObj.setStudent_names(result.getString("student_names"));
               studentList.add(studentObj);
           }
           Con.close();
           return studentList;
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return null;
   }
}
