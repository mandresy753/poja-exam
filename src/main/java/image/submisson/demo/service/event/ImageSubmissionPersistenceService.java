package image.submisson.demo.service;

import image.submisson.demo.mapper.ImageSubmissionMapper;
import image.submisson.demo.model.ImageSubmission;
import image.submisson.demo.repository.ImageSubmissionRepository;
import image.submisson.demo.repository.model.JImageSubmission;
import java.time.Instant;
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
}
