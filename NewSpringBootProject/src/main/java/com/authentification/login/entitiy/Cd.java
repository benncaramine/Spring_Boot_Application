package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cd")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "cd_id")
    private Integer cd_id;


    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
