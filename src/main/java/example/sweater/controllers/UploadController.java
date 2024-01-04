package example.sweater.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/upload")
    public String upload() {
        System.out.println(uploadPath);
        return "upload";
    }

    @PostMapping("/upload-file")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        File uploadDir = new File(uploadPath);

        if(!uploadDir.isDirectory()) {
            uploadDir.mkdir();
        }
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "." + file.getOriginalFilename();
        System.out.println(uploadPath + "\\" + fileName);
        file.transferTo(new File(uploadPath + "\\" + fileName));

        return "redirect:/upload";
    }
}
