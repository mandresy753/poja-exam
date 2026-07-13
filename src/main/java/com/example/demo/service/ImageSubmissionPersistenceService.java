package com.example.demo.service;

import com.example.demo.mapper.ImageSubmissionMapper;
import com.example.demo.model.ImageSubmission;
import com.example.demo.repository.ImageSubmissionRepository;
import com.example.demo.repository.model.JImageSubmission;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageSubmissionPersistenceService {

  private final ImageSubmissionRepository repository;

  private final ImageSubmissionMapper mapper;

  public ImageSubmission save(UUID id, String filename, String email) {

    JImageSubmission entity =
            JImageSubmission.builder()
                    .id(id)
                    .nomFichier(filename)
                    .email(email)
                    .createdAt(Instant.now())
                    .build();

    return mapper.toModel(repository.save(entity));
  }

  public List<ImageSubmission> findAll() {
    return repository.findAll().stream().map(mapper::toModel).toList();
  }
}