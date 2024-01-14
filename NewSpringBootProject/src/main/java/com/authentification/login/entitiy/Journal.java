package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "journal")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journal_id")
    private Integer  journal_id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
