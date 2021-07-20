package com.dosja.Dosja.service;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;


public interface FileUploadService {

    void upload(MultipartFile file) throws IOException;
}