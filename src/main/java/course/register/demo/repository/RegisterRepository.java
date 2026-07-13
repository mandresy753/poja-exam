package course.register.demo.repository;

import course.register.demo.repository.model.JRegister;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<JRegister, UUID> {}
