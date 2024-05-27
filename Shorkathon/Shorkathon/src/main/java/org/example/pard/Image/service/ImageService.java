package org.example.pard.Image.service;

import org.example.pard.Image.entity.Image;
import org.example.pard.Image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

@Service
public class ImageService {


    @Autowired
    private ImageRepository imageRepository;

    public ResponseEntity<Long> uploadImage(MultipartFile image) {
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        try {
            // Save the uploaded file to a temporary location
            String tempDir = System.getProperty("java.io.tmpdir");
            String tempFilePath = tempDir + image.getOriginalFilename();
            image.transferTo(new File(tempFilePath));

            // Read the image to validate it
            BufferedImage bufferedImage = ImageIO.read(new File(tempFilePath));
            if (bufferedImage == null) {
                System.out.println("The provided file is not a valid image.");
                return ResponseEntity.badRequest().body(null);
            }

            // Define the directory to save the image
            String uploadDir = "/Users/ision/Desktop/Server-Sion/Shorkathon/Shorkathon/src/main/resources/static/images/";
            Files.createDirectories(Paths.get(uploadDir));

            // Save image record in the database to get the ID
            Image imageRecord = new Image();
            imageRecord.setFilePath("");
            Image savedImage = imageRepository.save(imageRecord);

            // Create the new file name using the image ID
            String newFileName = "image" + savedImage.getImageId() + ".jpg";
            File outputFile = new File(uploadDir + newFileName);

            // Save the image file with the new name
            ImageIO.write(bufferedImage, "jpg", outputFile);

            // Update the image record with the correct file path and save again
            imageRecord.setFilePath(outputFile.getAbsolutePath());
            imageRepository.save(imageRecord);

            // Delete the temporary file
            new File(tempFilePath).delete();

            return ResponseEntity.ok(savedImage.getImageId());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    public String getFilePathById(Long imageId) {
        return findById(imageId).getFilePath();
    }

    public Image findById(Long imageId) {
        return imageRepository.findById(imageId).orElseThrow();
    }
    /*
    public Image getPostImage(Long postId) {
        return imageRepository.findByPosting_PostId(postId);
    }

    public Long getPostId() {
        return imageRepository.findTopByOrderByPostId().getPostId();
    }

     */
}