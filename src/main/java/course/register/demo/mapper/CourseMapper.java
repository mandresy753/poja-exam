package course.register.demo.mapper;

import course.register.demo.model.Course;
import course.register.demo.repository.model.JCourse;
import java.util.List;
import lombok.Getter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CourseMapper {
  private final UserMapper userMapper;
  private final RegisterMapper registerMapper;

  public CourseMapper(UserMapper userMapper, @Lazy RegisterMapper registerMapper) {
    this.userMapper = userMapper;
    this.registerMapper = registerMapper;
  }

  public List<Course> toModel(List<JCourse> jCourses) {
    return jCourses.stream().map(this::toModel).toList();
  }

  public Course toModel(JCourse jCourse) {
    return Course.builder()
        .id(jCourse.getId())
        .title(jCourse.getTitle())
        .startDate(jCourse.getStartDate())
        .endDate(jCourse.getEndDate())
        .build();
  }

  public List<Course> toModelWithRegister(List<JCourse> jCourses) {
    return jCourses.stream().map(this::toModelWithRegister).toList();
  }

  public Course toModelWithRegister(JCourse jCourse) {
    return Course.builder()
        .id(jCourse.getId())
        .title(jCourse.getTitle())
        .startDate(jCourse.getStartDate())
        .endDate(jCourse.getEndDate())
        .registers(registerMapper.toModelWithoutCourse(jCourse.getJRegisters()))
        .build();
  }

  public List<JCourse> toEntity(List<Course> courses) {
    return courses.stream().map(this::toEntity).toList();
  }

  public JCourse toEntity(Course course) {
    return JCourse.builder()
        .id(course.id())
        .title(course.title())
        .startDate(course.startDate())
        .endDate(course.endDate())
        .build();
  }
}
