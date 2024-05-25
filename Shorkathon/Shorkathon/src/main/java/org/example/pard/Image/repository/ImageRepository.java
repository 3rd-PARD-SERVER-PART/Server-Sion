package org.example.pard.Image.repository;

import org.example.pard.Image.entity.Image;
import org.example.pard.Image.service.ImageService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {


    ;
}

