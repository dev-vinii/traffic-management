package br.com.fiap.traffic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_traffic_light")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TrafficLight {

    @Id
    @GeneratedValue (
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
    private int timeToOpen;
    private boolean pedestrianTrafficLight;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "street_id", insertable = false, updatable = false)
    private Street street;
}
