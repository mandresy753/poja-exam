package com.example.demo.repository.model;

import com.example.demo.PojaGenerated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@PojaGenerated
@Entity
@Getter
@Setter
public class DummyUuid {
  private Long id1;
  @Id
  private String id;
}
