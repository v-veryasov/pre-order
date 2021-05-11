package ru.edu.iorder.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_uuid")
    private UUID userUuid;

    @Column(name = "assessment")
    private int assessment;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrdStatus ordStatus;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "finish_date")
    private Instant finishDate;

    //@ToString.Exclude
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<Position> positions;

}
