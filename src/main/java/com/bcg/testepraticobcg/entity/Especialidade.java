package com.bcg.testepraticobcg.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_especialidade")
public class Especialidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;


    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;


}
