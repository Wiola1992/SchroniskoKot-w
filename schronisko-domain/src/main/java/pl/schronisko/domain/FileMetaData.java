package pl.schronisko.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name="files")
public class FileMetaData {

	@Column(name="nazwa_pliku")
	String name;
	
	@Column(name="oryginalna_nazwa")
	String originalFilename;
	
	@Column(name="typ_zawartosci")
	String contentType;
	
	@Column(name="rozmiar")
	Long size;
	
	@Column(name="opis")
	String description;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_pliku")
	Long idFile;	
	
	@ManyToOne
	@JoinColumn(name="id_kota")
	cat fileOwner;
	
	public FileMetaData() {
		super();
	}
 
	public FileMetaData(String name, String originalFilename, String contentType, Long size, String description, Long idFile,
			cat owner) {
		super();
		this.name = name;
		this.originalFilename = originalFilename;
		this.contentType = contentType;
		this.size = size;
		this.description = description;
		this.idFile = idFile;
		this.fileOwner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdFile() {
		return idFile;
	}

	public void setIdFile(Long idFile) {
		this.idFile = idFile;
	}

	public cat getFileOwner() {
		return fileOwner;
	}

	public void setFileOwner(cat fileOwner) {
		this.fileOwner = fileOwner;
	}

	
}
