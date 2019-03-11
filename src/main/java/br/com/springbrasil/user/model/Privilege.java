package br.com.springbrasil.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Collection<Role> roles;
}
