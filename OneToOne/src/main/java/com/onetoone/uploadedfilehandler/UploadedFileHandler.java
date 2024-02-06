package com.onetoone.uploadedfilehandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class UploadedFileHandler {
	
//	public final String path="C:\\Users\\2097637\\OneDrive - Cognizant\\Desktop\\ALLPRojects\\SPRING\\SpringbootWithmicroservices\\OneToOne\\src\\main\\java\\com\\onetoone\\uploadedfilehandler\\";
//	
//public String upload(MultipartFile file) throws IOException {
//	try {
//		Files.copy(file.getInputStream(),Paths.get(path+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );		
//	} catch (Exception e) {
//		// TODO: handle exception
//		
//	}
//
//	
//	return "File uploaded Sucessfully";
//	
//	
//}
	
	public final String path=new ClassPathResource("/src/main/resources/static/image").getPath();
	
	public String upload(MultipartFile file) throws IOException {
	try {
		Files.copy(file.getInputStream(),Paths.get(path+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );		
		return ServletUriComponentsBuilder.fromCurrentContextPath().path(path).path(file.getOriginalFilename()).toUriString();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	
	return "File uploaded Sucessfully";
	
	
}

}
