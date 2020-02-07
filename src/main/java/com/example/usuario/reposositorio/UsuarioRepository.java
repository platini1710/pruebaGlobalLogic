package com.example.usuario.reposositorio;

import java.util.List;

import com.example.usuario.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
public interface  UsuarioRepository  extends JpaRepository<Usuarios, String> {
	public List<Usuarios> findAllUser();
	
	public Usuarios findUserByEmail(String Correo);
	public void saveUsuarios(Usuarios usuarios);
}
