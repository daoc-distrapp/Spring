package com.example.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebController {
	public static final String FILES_PATH = "C:\\Users\\ordon\\Downloads";
	
	@PostMapping("/uploadOneFile")
	@ResponseBody
	public  String uploadOneFile(@RequestParam("f") MultipartFile tmpMpFile) throws IOException {
		Path fileInDisk = Paths.get(FILES_PATH, tmpMpFile.getOriginalFilename());
		
		Files.copy(tmpMpFile.getInputStream(), fileInDisk);
		
		return "Guardado: " + fileInDisk;
	}

	@PostMapping("/uploadFiles")
	@ResponseBody
	public  String uploadFiles(@RequestParam("f") MultipartFile[] tmpMpfiles) throws IOException {
		String response = "Guardados: ";
		for(MultipartFile f : tmpMpfiles) {
			Path fileInDisk = Paths.get(FILES_PATH, f.getOriginalFilename());			
			Files.copy(f.getInputStream(), fileInDisk);
			response += fileInDisk + " : ";
		}
		return response;
	}	
	
	@GetMapping("/download/{f}")
	public ResponseEntity<?> download(@PathVariable("f") String filename) throws IOException {
		Path file = Paths.get(FILES_PATH, filename);
		FileSystemResource fsr = new FileSystemResource(file);
	
        return ResponseEntity.ok()
        	.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fsr.getFilename() + "\"")
        	.body(fsr);
	}

}
