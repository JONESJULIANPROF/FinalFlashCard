/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guireadwritelecture;

/**
 *
 * @author Brad
 */
public class Company {
    private int id;
    private String fname,lname,company,email;
    //setter,getters,both constructors,toString

    public Company() {
    }

    public Company(int id, String fname, String lname, String company, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.company = company;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", company=" + company + ", email=" + email + '}';
    }
    
}
