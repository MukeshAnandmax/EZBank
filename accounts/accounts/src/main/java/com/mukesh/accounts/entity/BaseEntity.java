package com.mukesh.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter@Setter@ToString
@MappedSuperclass
public class BaseEntity {

/**
 *  @Column(updatable = false)   :   Explanation
 *  
    In Java's Java Persistence API (JPA), the @Column annotation is used to specify the details of a column in the database table
    that corresponds to a field or property in an entity class. The updatable attribute of the @Column annotation is a boolean value
    that determines whether the column's value can be updated after the entity is initially persisted (saved) to the database.

    When you set @Column(updatable = false), it means that once the entity has been persisted, the value of this column
    cannot be changed by updating the entity and then merging it back into the persistence context. Essentially, this column
    becomes read-only after the initial insert operation.

 **/

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

}
