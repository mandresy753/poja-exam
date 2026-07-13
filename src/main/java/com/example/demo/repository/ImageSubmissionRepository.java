package com.example.demo.repository;

import com.example.demo.repository.model.JImageSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageSubmissionRepository extends JpaRepository<JImageSubmission, UUID> {}
