package br.com.fiap.traffic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Table(name = "tbl_traffic_light")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TrafficLight {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TRAFFIC_LIGHT"
    )
    @SequenceGenerator(
            name = "SEQ_TRAFFIC_LIGHT",
            sequenceName = "SEQ_TRAFFIC_LIGHT",
            allocationSize = 1
    )
    @Column(name = "traffic_light_id")
    private Long id;

    @Column(name = "time_to_open", nullable = false)
    private int timeToOpen;

    @Column(name = "pedestrian_traffic_light", nullable = false)
    private boolean pedestrianTrafficLight;

    @Column(name = "brand", nullable = false)
    private String brand;

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    private Street street;

}