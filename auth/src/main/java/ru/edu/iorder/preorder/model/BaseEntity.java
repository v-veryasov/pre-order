package ru.edu.iorder.preorder.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Data
@EqualsAndHashCode
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private Instant created;

    @LastModifiedDate
    @Column(name = "updated")
    private Instant updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
