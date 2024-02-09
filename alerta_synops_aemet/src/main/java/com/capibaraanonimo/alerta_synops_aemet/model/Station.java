package com.capibaraanonimo.alerta_synops_aemet.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Station {
    @Id
    @Column(columnDefinition = "uuid", name = "station_id")
    private UUID id;

    @NaturalId()
    @Column(unique = true)
    private String name;

    private Duration checkTime = Duration.ofHours(3);

    @ElementCollection
    private List<String> chats = new ArrayList<String>();
}
