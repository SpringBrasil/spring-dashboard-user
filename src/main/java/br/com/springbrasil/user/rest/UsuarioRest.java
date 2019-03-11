package br.com.springbrasil.user.rest;

import br.com.springbrasil.user.model.Usuario;
import br.com.springbrasil.user.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuaruios() {
        return usuarioService.findAllUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario getUsuarioById(@PathVariable("id") long id) {
        return usuarioService.findUsuarioById(id);
    }

    @GetMapping(value = "/buscar/{nome}")
    public Usuario getUsuarioByNome(@PathVariable("nome") String nome) {
        return usuarioService.findUsuarioByNome(nome);
    }

    @PostMapping
    public void postUsuario(@RequestParam Usuario usuario) {
        usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuarioById(id);
    }
}
