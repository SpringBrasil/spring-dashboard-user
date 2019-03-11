package br.com.springbrasil.user.model;

import br.com.springbrasil.user.model.Privilege;
import br.com.springbrasil.user.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles")
    private Collection<Usuario> usuarios;

    @ManyToMany(fetch =FetchType.EAGER)
    @Getter
    @Setter
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;
}
