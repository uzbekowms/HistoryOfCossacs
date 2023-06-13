package ua.history.service;

import jakarta.annotation.Nonnull;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class ResourceService {

    public Resource getFile(@Nonnull String name) throws FileNotFoundException {
        Path imagePath = ResourceUtils.getFile(new FileSystemResource("").getFile().getAbsolutePath() + "/files/" + name).toPath();
        Resource resource = new FileSystemResource(imagePath);
        if (!resource.exists())
            throw new FileNotFoundException("Cannot find image with name: " + name);

        return resource;
    }

    public String writeFile(@Nonnull MultipartFile file) {
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        System.out.println("extension - " + FilenameUtils.getExtension(file.getOriginalFilename()));
        saveFile(file, fileName);
        return fileName;
    }

    public void updateFile(@Nonnull MultipartFile file, String filename) {
        saveFile(file, filename);
    }


    private void saveFile(MultipartFile file, String filename) {
        try {
            String uploadDir = new FileSystemResource("").getFile().getAbsolutePath() + "/files/";

            File dest = new File(uploadDir + filename);
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong while uploading image");
        }
    }
}
