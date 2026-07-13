package course.register.demo.service;

import course.register.demo.endpoint.event.EventProducer;
import course.register.demo.endpoint.event.model.RegisterCreated;
import course.register.demo.endpoint.rest.controller.health.dto.RegisterRequest;
import course.register.demo.exception.NotFoundException;
import course.register.demo.mail.Mailer;
import course.register.demo.mapper.RegisterMapper;
import course.register.demo.model.Register;
import course.register.demo.repository.RegisterRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {
  private final RegisterMapper registerMapper;
  private final RegisterRepository registerRepository;
  private final UserService userService;
  private final EventProducer<RegisterCreated> eventProducer;
  private final Mailer mailer;

  public Register create(UUID courseId, RegisterRequest registerRequest) {
    var registerId = UUID.randomUUID();
    var asEntity = registerMapper.toEntity(registerId, courseId, registerRequest);
    var saved = registerMapper.toModel(registerRepository.save(asEntity));
    eventProducer.accept(List.of(new RegisterCreated(saved)));
    return saved;
  }

  public List<Register> registers() {
    return registerMapper.toModel(registerRepository.findAll());
  }

  public Register getById(UUID id) {
    return registerMapper.toModel(
        registerRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Register with id " + id + " not found")));
  }
}
