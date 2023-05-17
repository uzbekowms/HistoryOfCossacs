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
        try {
            String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            String uploadDir = getClass().getResource("/images/").getPath();
            System.out.println(uploadDir);

            File dest = new File(uploadDir + fileName);
            file.transferTo(dest);

            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Не вдалось зберегти файл");
        }
    }
}
