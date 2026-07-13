package image.submisson.demo.mapper;


import image.submisson.demo.model.ImageSubmission;
import image.submisson.demo.repository.model.JImageSubmission;

import org.springframework.stereotype.Component;


@Component
public class ImageSubmissionMapper {
    public ImageSubmission toModel(
            JImageSubmission entity
    ){
        return ImageSubmission.builder()
                .id(entity.getId())
                .nomFichier(entity.getNomFichier())
                .email(entity.getEmail())
                .createdAt(entity.getCreatedAt())
                .build();

    }


}