package com.example.demo.service;

import com.example.demo.endpoint.event.EventProducer;
import com.example.demo.endpoint.event.model.ImageSubmissionCreated;
import com.example.demo.model.ImageSubmission;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ImageSubmissionService {

  private final ImageConverterService converterService;

  private final ImageStorageService storageService;

  private final ImageSubmissionPersistenceService persistenceService;

  private final EventProducer<ImageSubmissionCreated> eventProducer;

  public ImageSubmission submit(MultipartFile image, String email) throws IOException {
    validate(image, email);

    UUID id = UUID.randomUUID();

    byte[] blackWhite = converterService.convert(image);

    String s3Key = storageService.upload(id, blackWhite);

    ImageSubmission saved = persistenceService.save(id, image.getOriginalFilename(), email);

    eventProducer.accept(
        List.of(
            ImageSubmissionCreated.builder()
                .imageSubmissionId(id)
                .email(email)
                .s3Key(s3Key)
                .build()));

    return saved;
  }

  public List<ImageSubmission> findAll() {
    return persistenceService.findAll();
  }

  private void validate(MultipartFile image, String email) {
    if (image == null || image.isEmpty()) {
      throw new IllegalArgumentException("Image obligatoire");
    }

    if (email == null || !email.contains("@")) {
      throw new IllegalArgumentException("Email invalide");
    }
  }
}
