package ru.edu.iorder.profile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "calendars")
public class Calendar extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "user_uuid")
    private UUID userUuid;

    @ManyToOne
    private Profile profile;

    @OneToMany(mappedBy = "calendar", fetch = FetchType.LAZY)
    private List<Day> days;
}
