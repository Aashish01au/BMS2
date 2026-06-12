package com.revesion.bms2.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class UploadController {

	@GetMapping("upload")
	public String getUpload(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return"LoginForm";
		}
		return"UploadForm";
	}
	
	@PostMapping("upload")
	public String postUpload(@RequestParam MultipartFile image,Model model) {
		
		if(!image.isEmpty()) {
			try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			model.addAttribute("message","Upload SuccessFull");
			return "UploadForm";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("message","Upload Failed!!!");
		return"UploadForm";
	}
}
