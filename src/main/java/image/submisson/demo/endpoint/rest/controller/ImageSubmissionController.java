package image.submisson.demo.endpoint.rest.controller;

import image.submisson.demo.model.ImageSubmission;
import image.submisson.demo.service.event.ImageSubmissionService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ImageSubmissionController {
  private final ImageSubmissionService service;

  @GetMapping
  public List<ImageSubmission> findAll() {
    return service.findAll();
  }

  @PostMapping
  public ImageSubmission submit(
      @RequestParam("image") MultipartFile image, @RequestParam("email") String email) {
    return service.submit(image, email);
  }
}
