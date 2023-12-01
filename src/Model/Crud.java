/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kebean
 */
public class Crud {
    private int stid;
    private String student_names;

    public Crud() {
    }

    public Crud(int stid, String student_names) {
        this.stid = stid;
        this.student_names = student_names;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getStudent_names() {
        return student_names;
    }

    public void setStudent_names(String student_names) {
        this.student_names = student_names;
    }
}
