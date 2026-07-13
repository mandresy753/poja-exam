package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import com.example.demo.file.bucket.BucketComponent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageStorageService {
  private final BucketComponent bucketComponent;

  public String upload(UUID id, byte[] content) throws IOException {

    File file = File.createTempFile("image-" + id, ".png");

    Files.write(file.toPath(), content);
    String key = "images/" + id + ".png";
    bucketComponent.upload(file, key);
    file.delete();
    return key;
  }
}
