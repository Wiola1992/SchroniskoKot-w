/*
 * Decompiled with CFR 0_123.
 */
package pl.schronisko.domain;

import java.io.PrintStream;
import java.util.Date;
//import java.sql.Date;



public class cat {
	
    private String name;
    public Date dateOfBirth = null;
    private double weight;
    private String nameOfGuardian;
    private int id;

    public void przedstawSie() {
        System.out.println(String.valueOf(this.name) + " waga  " + this.weight + " urodzil sie " + this.dateOfBirth + " a jego opiekun to " + this.nameOfGuardian);
    }

   public cat() {
	   
   }

    public cat(String name) {
        this.name = name;
    }

    public cat(String name, double weight, String guardian) {
        this(name);
        this.weight = weight;
        this.nameOfGuardian = guardian;
    }
    
    public cat(String name, double weight, String guardian, int id) {
    	this(name, weight, guardian);
    	this.id =id;
    }
    
    public cat(String name, double weight, String guardian, int id, Date dateOfBirth ) {
    	this(name, weight, guardian, id);
    	this.dateOfBirth =dateOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuardian() {
        return this.nameOfGuardian;
    }

    public void setGuardian(String guardian) {
        this.nameOfGuardian = guardian;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }
}