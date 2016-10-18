package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    public Usuario find(String email){
        Usuario usuario = manager.find(Usuario.class, email);

        if(usuario == null){
            throw new RuntimeException("O usuário "+ email +" não foi encontrado");
        }

        return usuario;
    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return find(email);
	}
}	