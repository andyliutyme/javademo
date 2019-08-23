package com.example.demo.data.anemics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseAnemic {
    //region Properties
    @Id
    private String id;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private String createdBy;
    //endregion

    protected void initialize(String createdBy)
    {
        this.id = UUID.randomUUID().toString();
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
        this.createdBy = createdBy;
    }
}
