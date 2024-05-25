package br.com.fiap.traffic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_street")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STREET")
    @SequenceGenerator(name = "SEQ_STREET", sequenceName = "SEQ_STREET", allocationSize = 1)
    @Column(name = "street_id")
    private Long id;

    private String cep;
    private String name;
}
