package com.convenience.web.dto;

import com.convenience.domain.File;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileDto {
    private Long id;
    private String originalFileName;
    private String fileName;
    private String filePath;

    public File toEntity() {
        return File.builder()
                .id(id)
                .originalFileName(originalFileName)
                .fileName(fileName)
                .filePath(filePath)
                .build();
    }

    @Builder
    public FileDto(Long id, String originalFileName, String fileName, String filePath) {
        this.id = id;
        this.originalFileName = originalFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
