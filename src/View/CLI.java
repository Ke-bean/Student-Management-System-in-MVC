/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.util.*;
import Model.Crud;
import DAO.StudentDAO;
/**
 *
 * @author Kebean
 */
public class CLI {
    public static void main(String[] args) {
        boolean condition = true;
        int id;
        String fullNames;
        String answer;
        String feedBack;
        Crud st = new Crud();
        StudentDAO stdao = new StudentDAO();
        while(condition){
             System.out.println("===================");
            System.out.println("1. Register student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Search student");
            System.out.println("5. Retrieve All student");
            System.out.println("0. Exit");
            System.out.println("Choice");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Id of the New Student: ");
                    id = input.nextInt();
                    while(Integer.toString(id).length() != 5){
                        System.out.println("Id characters must be five");
                        System.out.println("Enter Id again");
                        id = input.nextInt();
                    }
                    System.out.print("Enter Full Names of the new student: ");
                    fullNames = input.next();
                    st.setStid(id);
                    st.setStudent_names(fullNames);
                    feedBack = stdao.createStudent(st);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes to Continue or No to Exit");
                    answer = input.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    break;
                case 2:
                    System.out.println("Enter Student Id");
                    id = input.nextInt();
                    System.out.println("Enter new Student Names");
                    fullNames = input.next();
                    st.setStid(id);
                    st.setStudent_names(fullNames);
                    feedBack = stdao.updateStudent(st);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes to Continue or No to Exit");
                    answer = input.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    break;
                case 3:
                    System.out.println("Enter Id");
                    id = input.nextInt();
                    st.setStid(id);
                    feedBack = stdao.deleteStudent(st);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes to Continue or No to Exit");
                    answer = input.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    break;
                case 4:
                    System.out.println("Enter Id");
                    id = input.nextInt();
                    st.setStid(id);
                    feedBack = stdao.searchStudent(st);
                    System.out.println(feedBack);
                    System.out.println("Enter Yes to Continue or No to Exit");
                    answer = input.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    break;
                case 5:
                    stdao = new StudentDAO();
                    List<Crud> students = stdao.allStudent();
                    // This iterator thing is to be used when i choose to use a while loop
                    //Iterator iterator = students.iterator();
                    int counter = 0;
                    if(students != null){
                        for(Crud theStudent : students){
                            counter++;
                            System.out.println("Student " + counter);
                            System.out.println("Names:" + theStudent.getStudent_names());
                            System.out.println("Id:" + theStudent.getStid());
                            
                        }
                        // using a for loop instead of a for each loop above
                        //while(iterator.hasNext()){
                            
                        //}
                    }
                    break;
                case 0:
                    System.out.println("Thanks for using the system");
                    System.exit(0);
                default:
                    System.out.println("Enter the correct options from options above.");
            }
        }
    }
}
