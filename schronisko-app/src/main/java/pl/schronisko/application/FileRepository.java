package pl.schronisko.application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.schronisko.domain.FileMetaData;
import pl.schronisko.domain.cat;

@Repository
public interface FileRepository extends CrudRepository<FileMetaData, Long> {

	
	//public FileMetaData findById(Long  idFile);
	public FileMetaData findByName(String name);
	public List<FileMetaData> findAllByFileOwner(cat fileOwner);
}
