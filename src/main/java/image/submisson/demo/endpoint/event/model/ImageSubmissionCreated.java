package image.submisson.demo.endpoint.event.model;

import java.time.Duration;
import lombok.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
public class ImageSubmissionCreated extends PojaEvent {
    private UUID imageSubmissionId;
    private String email;
    private String s3Key;
    @Override
    public Duration maxConsumerDuration() {
        return Duration.ofSeconds(45);
    }
    @Override
    public Duration maxConsumerBackoffBetweenRetries() {
        return Duration.ofSeconds(60);
    }

}
