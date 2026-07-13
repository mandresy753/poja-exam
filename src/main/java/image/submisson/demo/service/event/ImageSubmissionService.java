package image.submisson.demo.service.event;

import image.submisson.demo.endpoint.event.EventProducer;
import image.submisson.demo.endpoint.event.model.ImageSubmissionCreated;
import image.submisson.demo.model.ImageSubmission;
import image.submisson.demo.service.ImageConverterService;
import image.submisson.demo.service.ImageSubmissionPersistenceService;
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

  public ImageSubmission submit(MultipartFile image, String email) {
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

  private void validate(MultipartFile image, String email) {
    if (image == null || image.isEmpty()) {
      throw new IllegalArgumentException("Image obligatoire");
    }
    if (email == null || !email.contains("@")) {
      throw new IllegalArgumentException("Email invalide");
    }
  }
}
