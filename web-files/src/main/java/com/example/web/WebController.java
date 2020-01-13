package com.example.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	public static final String FILES_PATH = "C:\\Users\\dordonez\\Downloads";
	
	@PostMapping("/uploadOneFile")
	@ResponseBody
	public  String uploadOneFile(@RequestParam("f") MultipartFile file) throws IOException {
		Files.copy(
			file.getInputStream()
			, Paths.get(FILES_PATH, getFileName(file.getOriginalFilename())));
		return "Recibido: " + file.getOriginalFilename() + " : " + file.getSize();
	}

	@PostMapping("/uploadFiles")
	@ResponseBody
	public  String uploadFiles(@RequestParam("f") MultipartFile[] files) throws IOException {
		String response = "Recibidos: ";
		for(MultipartFile f : files) {
			Files.copy(
				f.getInputStream()
				, Paths.get(FILES_PATH, getFileName(f.getOriginalFilename())));
			response += f.getOriginalFilename() + " : " + f.getSize() + " / ";
		}
		return response;
	}	
	
	@GetMapping("/download/{f}")
	public ResponseEntity<?> download(@PathVariable("f") String filename) throws IOException {
		Path file = Paths.get(FILES_PATH, filename);
		FileSystemResource fsr = new FileSystemResource(file);

		MediaType mime;
		if(Files.probeContentType(file) == null) {
			mime = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mime = MediaType.parseMediaType(Files.probeContentType(file));
		}
		
		if(fsr.exists()) {		
	        return ResponseEntity.ok()
	        	.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fsr.getFilename() + "\"")
	        	.contentLength(fsr.contentLength())
	        	.contentType(mime)
	        	.body(fsr);
		} else {
			return ResponseEntity.badRequest().body("File not found");
		}

	}
	
	private String getFileName(String fileName) {
		Path path = Paths.get(fileName);
		return path.getFileName().toString();
	}
}
