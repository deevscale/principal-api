package com.deevscale.principalapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(name = "created_by")
    @CreatedBy
    protected UUID createdBy;

    @Column(name = "created_at")
    @CreatedDate
    protected Instant createdAt;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected UUID modifiedBy;

    @Column(name = "modified_at")
    @LastModifiedDate
    protected Instant modifiedAt;

    @Column(name = "deleted_by")
    protected UUID deletedBy;

    @Column(name = "deleted_at")
    protected Instant deletedAt;

    public BaseEntity(UUID id, UUID createdBy, Instant createdAt, UUID modifiedBy, Instant modifiedAt, UUID deletedBy, Instant deletedAt) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.deletedBy = deletedBy;
        this.deletedAt = deletedAt;
    }

    public BaseEntity(UUID createdBy, Instant createdAt, UUID modifiedBy, Instant modifiedAt, UUID deletedBy, Instant deletedAt) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.deletedBy = deletedBy;
        this.deletedAt = deletedAt;
    }

    public BaseEntity(UUID modifiedBy, Instant modifiedAt, UUID deletedBy, Instant deletedAt) {
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.deletedBy = deletedBy;
        this.deletedAt = deletedAt;
    }

    public BaseEntity(UUID deletedBy, Instant deletedAt) {
        this.deletedBy = deletedBy;
        this.deletedAt = deletedAt;
    }


}
