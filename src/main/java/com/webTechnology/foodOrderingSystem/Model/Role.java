package com.webTechnology.foodOrderingSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = false, nullable = true)
    @NotEmpty
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
