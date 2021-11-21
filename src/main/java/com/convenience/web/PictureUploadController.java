package com.convenience.web;

import com.convenience.service.FileService;
import com.convenience.util.MD5Generator;
import com.convenience.web.dto.FileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class PictureUploadController {
    private FileService fileService;

    public PictureUploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/file/upload")
    public ResponseEntity upload(@RequestParam("file")MultipartFile files) {
        try {
            String originalFileName = files.getOriginalFilename();
            String fileName = new MD5Generator(originalFileName).toString();
            /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
            String savePath = System.getProperty("user.dir") + "\\files";
            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + fileName;
            files.transferTo(new File(filePath));

            FileDto fileDto = new FileDto();
            fileDto.setOriginalFileName(originalFileName);
            fileDto.setFileName(fileName);
            fileDto.setFilePath(filePath);
           // Long fileId = fileService.saveFile(fileDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
