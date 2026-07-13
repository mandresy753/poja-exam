package course.register.demo.endpoint.rest.controller.health;

import course.register.demo.model.Course;
import course.register.demo.service.CourseService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {
  private final CourseService courseService;

  @GetMapping("/courses")
  public List<Course> courses() {
    return courseService.courses();
  }

  @GetMapping("/courses/{id}")
  public Course getById(@PathVariable UUID id) {
    return courseService.getById(id);
  }
}
