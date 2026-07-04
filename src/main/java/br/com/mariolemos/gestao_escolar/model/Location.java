package br.com.mariolemos.gestao_escolar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "locations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID vehicleId;

    private Double latitude;

    private Double longitude;

    private Double speed;

    private LocalDateTime createdAt = LocalDateTime.now();
}