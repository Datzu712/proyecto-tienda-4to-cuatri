
package com.tienda.service.impl;

import com.tienda.service.UsuarioDetailsService;
import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Usuario;
import com.tienda.domain.Rol;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null)
            throw new UsernameNotFoundException(username);

        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());

        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}