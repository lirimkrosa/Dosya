package com.dosja.Dosja.Impl;

import java.io.File;
import java.io.IOException;

import com.dosja.Dosja.service.FileUploadService;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public void upload(MultipartFile file) throws IOException {


        //below we mention the path where the file stores after upload
        file.transferTo(new File("~\\Desktop\\Files\\"+file.getOriginalFilename()));
    }
}