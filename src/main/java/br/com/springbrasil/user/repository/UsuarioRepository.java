package br.com.springbrasil.user.repository;

import br.com.springbrasil.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    Usuario findUsuarioByLogin(@Param("login") String login);

    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    Usuario findUsuarioByNome(@Param("nome") String nome);
}
