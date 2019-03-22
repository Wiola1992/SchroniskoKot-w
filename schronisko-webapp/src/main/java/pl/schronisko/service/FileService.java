package pl.schronisko.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import pl.schronisko.application.CatRepository;
import pl.schronisko.application.FileRepository;
import pl.schronisko.domain.FileMetaData;
import pl.schronisko.domain.cat;
import pl.schronisko.kontroler.FormularzDTOFile;

@Service
public class FileService {

	@Autowired
	FileRepository fileDAO;

	@Autowired
	CatRepository catDAO;

	public void saveFile(FormularzDTOFile fileAdd, int idKota) {
		MultipartFile mulpipart = fileAdd.getFile();
		FileMetaData file = new FileMetaData();
		file.setDescription(fileAdd.getDescription());
		file.setContentType(mulpipart.getContentType());
		file.setName(fileAdd.getName());
		file.setOriginalFilename(mulpipart.getOriginalFilename());
		file.setSize(mulpipart.getSize());

		/*
		 * Optional<cat> opt =catDAO.findById(idKota); cat kot = new cat();
		 * if(opt!=null) { kotek = opt.get(); }
		 */

		cat kotek = catDAO.findById(idKota);
		file.setFileOwner(kotek);

		fileDAO.save(file);
	}

	public FileMetaData findFileById(Long idFile) {
		Optional<FileMetaData> fileOpt =fileDAO.findById(idFile);
		if(fileOpt.isPresent()) {
			FileMetaData file = fileOpt.get();
			return file;
		} else {
			return new FileMetaData();
		}
	}
	public FileMetaData findFileByName(String name) {
		FileMetaData file =fileDAO.findByName(name);
		return file;
	}
	
	public List<FileMetaData> FindAllFiles(int idKota){
		cat kot = catDAO.findById(idKota);
		List<FileMetaData> files = fileDAO.findAllByFileOwner(kot);
		return files;
	}
}
