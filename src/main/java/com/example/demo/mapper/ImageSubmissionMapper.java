package com.example.demo.mapper;

import com.example.demo.model.ImageSubmission;
import com.example.demo.repository.model.JImageSubmission;
import org.springframework.stereotype.Component;

@Component
public class ImageSubmissionMapper {
  public ImageSubmission toModel(JImageSubmission entity) {
    return ImageSubmission.builder()
        .id(entity.getId())
        .nomFichier(entity.getNomFichier())
        .email(entity.getEmail())
        .createdAt(entity.getCreatedAt())
        .build();
  }
}
