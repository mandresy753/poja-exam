package image.submisson.demo.repository;

import image.submisson.demo.repository.model.JImageSubmission;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageSubmissionRepository extends JpaRepository<JImageSubmission, UUID> {}
