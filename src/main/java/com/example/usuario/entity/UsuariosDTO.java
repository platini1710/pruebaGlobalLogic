package com.example.usuario.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class UsuariosDTO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private String email;
private String password;
private String fechaCreacion;
private String  fechaModificacion;
private String last_login;
private UUID token;
private String isActive;
private List<PhonesDTO>  listPhone;	 

	public UsuariosDTO() {

	}
public UsuariosDTO(UUID id, String name, String email, String password) 
{

   this.name = name;
   this.email = email;
   this.password = password;
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhonesDTO> getListPhone() {
		return listPhone;
	}
	public void setListPhone(List<PhonesDTO> listPhone) {
		this.listPhone = listPhone;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	
	
}
