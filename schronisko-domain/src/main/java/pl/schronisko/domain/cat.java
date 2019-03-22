/*
 * Decompiled with CFR 0_123.
 */
package pl.schronisko.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="koty")
public class cat {
	
	@Column(name="imie")
    private String name;
	@Column(name="data")
    public LocalDate dateOfBirth = null;
	@Column(name="waga")
    private double weight;
	@Column(name="opiekun")
    private String nameOfGuardian;
   
	@Id
    @Column(name="idkota")
    private int id;
    
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="owner")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Toy> toysList;
   
	@JsonIgnore
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="fileOwner")
    @Fetch(value = FetchMode.SUBSELECT)
   
    private List<FileMetaData> filesList;

    public List<Toy> getToysList() {
		return toysList;
	}

	public void setToysList(List<Toy> toysList) {
		toysList = toysList;
	}

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
    
    public cat(String name, double weight, String guardian, int id, LocalDate  dateOfBirth ) {
    	this(name, weight, guardian, id);
    	this.dateOfBirth =dateOfBirth;
    }
    
    public cat(String name, double weight, String guardian, int id, LocalDate  dateOfBirth, List<Toy> toys ) {
    	this(name, weight, guardian, id);
    	this.dateOfBirth =dateOfBirth;
    	this.toysList = toys;
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

    public LocalDate  getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate  date) {
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

	public List<FileMetaData> getFilesList() {
		return filesList;
	}

	public void setFilesList(List<FileMetaData> filesList) {
		this.filesList = filesList;
	}
}
