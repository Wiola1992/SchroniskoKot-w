package pl.schronisko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name="toys")
public class Toy {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_zabawki")
	int idToys;
	
	@Column(name="nazwa")
	String name;
	
	@Column(name="opis")
	String description;
	
	@ManyToOne 
	@JoinColumn(name="strona_id_kota" )
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
