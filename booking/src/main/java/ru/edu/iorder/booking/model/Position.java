package ru.edu.iorder.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_uuid")
    private UUID photoUuid;

    @Column(name = "cost")
    private int cost;

    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "create_date")
    private Instant created;

    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updated;

    @ManyToOne
    private Price price;

    @ManyToOne
    private Booking booking;
}
