package course.register.demo.endpoint.rest.controller.health;

import course.register.demo.endpoint.rest.controller.health.dto.RegisterRequest;
import course.register.demo.model.Register;
import course.register.demo.service.RegisterService;
import jakarta.mail.internet.AddressException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegisterController {
  private final RegisterService registerService;

  @GetMapping("/registers")
  public List<Register> registers() {
    return registerService.registers();
  }

  @GetMapping("/registers/{id}")
  public Register getById(@PathVariable UUID id) {
    return registerService.getById(id);
  }

  @PostMapping("registers/courses/{courseId}")
  public Register register(
      @PathVariable UUID courseId, @RequestBody RegisterRequest registerRequest)
      throws AddressException {
    return registerService.create(courseId, registerRequest);
  }
}
