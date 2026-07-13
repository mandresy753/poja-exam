package course.register.demo.repository.model;

import course.register.demo.model.RegisterStatus;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "register")
@Builder
public class JRegister {
  @Id @GeneratedValue @UuidGenerator private UUID id;
  private Instant createdAt;

  @Enumerated(EnumType.STRING)
  private RegisterStatus registerStatus;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private JUser jUser;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private JCourse jCourse;
}
