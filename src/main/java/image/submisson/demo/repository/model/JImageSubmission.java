package image.submisson.demo.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

import lombok.*;

import org.hibernate.annotations.UuidGenerator;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name="image_submission")
public class JImageSubmission {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String nomFichier;
    private String email;
    private Instant createdAt;

}