package course.register.demo.repository.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "course_register")
@Entity
@Builder
public class JCourse {
  @GeneratedValue @UuidGenerator @Id private UUID id;
  private String title;
  private Instant startDate;
  private Instant endDate;

  @OneToMany(mappedBy = "jCourse")
  private List<JRegister> jRegisters;
}
