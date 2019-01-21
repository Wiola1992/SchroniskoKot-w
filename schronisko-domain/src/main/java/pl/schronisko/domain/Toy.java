package pl.schronisko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="toys")
public class Toy {
	
	@Id
	@Column(name="id_zabawki")
	int idToys;
	
	@Column(name="nazwa")
	String name;
	
	@Column(name="opis")
	String description;
	
	@ManyToOne 
	@JoinColumn(name="idkota"/*, referencedColumnName="idkota"*/)
	private cat owner;
	
	
	public Toy() {
		
	}

	public Toy(String name) {
		super();
		this.name = name;
	}
	
	public Toy(String name, int id, String opis) {
		this(name);
		//this.idkota = id;
		this.description = opis;
	}

	public int getIdToys() {
		return idToys;
	}

	public void setIdToys(int idToys) {
		this.idToys = idToys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public cat getOwner() {
		return owner;
	}

	public void setOwner(cat owner) {
		this.owner = owner;
	}
	

}
