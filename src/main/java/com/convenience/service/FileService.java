package com.convenience.service;

import com.convenience.domain.File;
import com.convenience.domain.repository.FileRepository;
import com.convenience.web.dto.FileDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .originalFileName(file.getOriginalFileName())
                .fileName(file.getFileName())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
