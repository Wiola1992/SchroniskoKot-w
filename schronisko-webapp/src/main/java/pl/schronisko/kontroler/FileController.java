package pl.schronisko.kontroler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import pl.schronisko.domain.FileMetaData;
import pl.schronisko.service.FileService;

@Controller
@RequestMapping
public class FileController {

	@Autowired
	FileService fileService;

	protected final Logger logger = Logger.getLogger(getClass().getName());

	// @Secured({ "ROLE_USER"})
	@RequestMapping(value = "/pokazkota/{id}/file", method = RequestMethod.GET)
	public String dodawaniePliku(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		model.addAttribute("fileAdd", new FormularzDTOFile());
		return "fileAdd";
	}

	// @Secured({ "ROLE_USER"})
	@RequestMapping(value = "/pokazkota/{id}/file/upload", method = RequestMethod.POST)
	public String obsluzFormularzPliku(@ModelAttribute("fileAdd") @Valid FormularzDTOFile fileAdd, BindingResult result,
			Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		MultipartFile multipartFile = fileAdd.getFile();
		if (multipartFile.isEmpty()) {
			logger.info("Uploaded file is empty");
			return "fileAdd";
		} else {
			System.out.println("Fetching file");
			try {
				UUID uuid = UUID.randomUUID();
				String filename = "dodawanie" + uuid.toString();
				fileAdd.setName(filename);
				byte[] bytes = multipartFile.getBytes();

				File fsFile = new File(filename);
				fsFile.createNewFile();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile));
				stream.write(bytes);
				stream.close();

				fileService.saveFile(fileAdd, id);

				logger.info("File has been uploaded" + multipartFile.getOriginalFilename());

				// Path path = Paths.get(UPLOADED_FOLDER + filename);
				// Files.write(path, bytes);
			} catch (Exception e) {
				logger.info("File has not been uploaded" + e.getMessage());
			}

			return "redirect:../../../pokazkota/{id}";
			// return "wszystkie";

		}

	}

	@RequestMapping(value = "/pokazkota/{id}/file/{nazwa}", method = RequestMethod.GET )
	public void getFileById(@PathVariable("nazwa") String nazwa, HttpServletResponse response) throws IOException {
		try { 
			FileMetaData metadataObject = fileService.findFileByName(nazwa);
			InputStream is = new FileInputStream(nazwa); 
			response.setContentType(metadataObject .getContentType()); 
			response.setContentLengthLong(metadataObject.getSize()); 
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream()); 
			response.flushBuffer(); 
		} catch (IOException ex) {
			logger.info("Błąd przy pobieraniu pliku "+ ex); 
			response.setStatus(404); 
			}
	}
	
}
	/*
	 * @Secured({ "ROLE_USER" })
	 * 
	 * @RequestMapping(value = "/kot/{idK}/upload", method = RequestMethod.GET)
	 * public String getUpload(Model model, @PathVariable("idK") Integer id) {
	 * FileBucket file = new FileBucket(); model.addAttribute("file", file); return
	 * "fileAdd"; }
	 * 
	 * @Secured({ "ROLE_USER" })
	 * 
	 * @RequestMapping(value = "/kot/{idK}/upload", method = RequestMethod.POST)
	 * public String handleFileUpload( @PathVariable("idK") Integer
	 * id, @RequestParam("plik") @Valid FileBucket file, BindingResult result, Model
	 * model) {
	 * 
	 * if (result.hasErrors()) { System.out.println("validation errors"); return
	 * "fileAdd"; }
	 * 
	 * else { System.out.println("Fetching file");} try { UUID uuid =
	 * UUID.randomUUID(); String filename = "/uploads/upload_" + uuid.toString();
	 * 
	 * MultipartFile multipartFile = file.getFile(); byte[] bytes =
	 * multipartFile.getBytes();
	 * 
	 * FileBucket fsFile = new File(Filename); Path path = Paths.get(UPLOADED_FOLDER
	 * + multipartFile.getOriginalFilename());
	 * 
	 * FileCopyUtils.copy(file.getFile().getBytes(), new
	 * File(uploadPath+file.getFile().getOriginalFilename())); String fileName =
	 * multipartFile.getOriginalFilename(); model.addAttribute("fileName",
	 * fileName); return "success";
	 */
	/*
	 * if (!file.isEmpty()) { try { UUID uuid = UUID.randomUUID(); String filename =
	 * "/uploads/upload_" + uuid.toString(); byte[] bytes = file.getBytes();
	 * 
	 * File fsFile = new File(filename); fsFile.createNewFile();
	 * BufferedOutputStream stream = new BufferedOutputStream(new
	 * FileOutputStream(fsFile)); stream.write(bytes); stream.close();
	 * logger.log(Level.INFO,"File {} has been successfully uploaded as {}", new
	 * Object[] { file.getOriginalFilename(), filename }); //
	 * logger.info("File {} has been successfully uploaded as {}", // new Object[] {
	 * file.getOriginalFilename(), filename }); } catch (Exception e) {
	 * logger.info("File has not been uploaded" + e.getMessage());
	 * //error("File has not been uploaded", e); } } else {
	 * logger.info("Uploaded file is empty");
	 * //logger.error("Uploaded file is empty"); }
	 * 
	 * return "redirect:../../../pokazkota/{id}";
	 * 
	 * }
	 */


