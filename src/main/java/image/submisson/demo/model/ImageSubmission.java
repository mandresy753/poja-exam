package image.submisson.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;


@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ImageSubmission(

        UUID id,

        String nomFichier,

        String email,

        Instant createdAt

) {}
