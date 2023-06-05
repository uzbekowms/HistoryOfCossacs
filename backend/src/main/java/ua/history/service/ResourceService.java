package ua.history.service;

import jakarta.annotation.Nonnull;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ResourceService {

    public InputStreamResource getFile(@Nonnull String name, String directory) {
        return new InputStreamResource(getClass().getResourceAsStream(directory + name));
    }

    public String writeFile(@Nonnull MultipartFile file) {
        String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        writeFile(file, fileName);
        return fileName;
    }

    public void updateFile(@Nonnull MultipartFile file, String filename) {
        writeFile(file, filename);
    }


    private void writeFile(MultipartFile file, String filename) {
        try {
            String uploadDir = getClass().getResource("/images/").getPath();
            File dest = new File(uploadDir + filename);
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException("Не вдалось зберегти файл");
        }
    }
}
