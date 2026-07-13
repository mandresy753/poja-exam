package course.register.demo.service;

import course.register.demo.exception.NotFoundException;
import course.register.demo.mapper.CourseMapper;
import course.register.demo.model.Course;
import course.register.demo.repository.CourseRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
  private final CourseMapper courseMapper;
  private final CourseRepository courseRepository;

  public List<Course> courses() {
    return courseMapper.toModelWithRegister(courseRepository.findAll());
  }

  public Course getById(UUID id) {
    return courseMapper.toModel(
        courseRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Course with id " + id + " not found")));
  }
}
