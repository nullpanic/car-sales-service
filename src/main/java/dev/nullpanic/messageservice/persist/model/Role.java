package dev.nullpanic.messageservice.persist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "ROLES_SEQ_GENERATOR", sequenceName = "ROLES_SEQ", allocationSize = 1)
@Table(name = "roles")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ_GENERATOR")
    @Column(name = "role_id")
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private dev.nullpanic.messageservice.enums.Role role;

}
