package com.example.demo.api.document.criterions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Getter
@NoArgsConstructor
public class UploadFileCriteria {
    private String documentTypeId;
    private Collection<MultipartFile> pages;
    private MultipartFile page;

    public UploadFileCriteria(String documentTypeId, Collection<MultipartFile> pages, MultipartFile page) {
        this.documentTypeId = documentTypeId;
        this.pages = pages;
        this.page = page;
    }

    public boolean isMultipleUpload() {
        if (this.pages != null && !this.pages.isEmpty()) {
            return true;
        }

        return false;
    }
}
