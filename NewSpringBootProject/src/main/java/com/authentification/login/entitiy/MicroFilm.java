package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "micro_film")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MicroFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "micro_id")
    private Integer micro_id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
