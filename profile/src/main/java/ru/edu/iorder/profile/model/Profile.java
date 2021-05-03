package ru.edu.iorder.profile.model;

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
@Table(name = "profiles")
public class Profile extends BaseEntity {

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "photo_uuid")
    private UUID photoUuid;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "city")
    private String city;

    @Column(name = "rating")
    private int rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    //@ToString.Exclude
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<User> users;

    //@ToString.Exclude
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Post> posts;

    //@ToString.Exclude
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Calendar> calendars;

    //@ToString.Exclude
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<PlaceProvision> placeProvisions;
}
