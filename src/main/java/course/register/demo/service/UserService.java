package course.register.demo.service;

import course.register.demo.exception.NotFoundException;
import course.register.demo.mapper.UserMapper;
import course.register.demo.model.User;
import course.register.demo.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
  private final UserMapper userMapper;
  private final UserRepository userRepository;

  public List<User> users() {
    return userMapper.toModel(userRepository.findAll());
  }

  public User getById(UUID id) {
    return userMapper.toModel(
        userRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("User with id " + id + " not found")));
  }
}
