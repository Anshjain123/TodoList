package com.carwashbackend.carWashMajorProjectBackend.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {

    public final String storageDirectoryPath = "images/";
    public String getPhotoUrl(MultipartFile file) {
        String filename = file.getOriginalFilename();
        Path storageDirectory = Paths.get(storageDirectoryPath);

        if(!Files.exists(storageDirectory)) {
            try {
                Files.createDirectories(storageDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String uniqueId = UUID.randomUUID().toString();
        String destination = storageDirectoryPath + "\\" + filename + uniqueId;

        try {
            Files.copy(file.getInputStream(), Path.of(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("getImage/")
                .path(filename)
                .path(uniqueId)
                .toUriString();

//        String uri = "random";

        return uri;
    }


    public byte[] getFile(String filename) throws IOException {

        Path destination = Paths.get(storageDirectoryPath + "\\" + filename);

        byte[] byteArray = Files.readAllBytes(destination);
        return byteArray;
    }

}
