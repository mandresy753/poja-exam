package course.register.demo.endpoint.rest.controller.health;

import course.register.demo.model.User;
import course.register.demo.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public List<User> users() {
    return userService.users();
  }

  @GetMapping("/users/{id}")
  public User getById(@PathVariable UUID id) {
    return userService.getById(id);
  }
}
