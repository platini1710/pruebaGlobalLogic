package com.example.usuario.model;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	 @Column(nullable = false)
private String name;
	 @Column(nullable = false)
private String email;
	 @Column(nullable = false)
private String password;
	 private java.util.Date  fecha_creacion;
	 private java.util.Date   fecha_modificacion;
	 private java.util.Date   last_login;

	 private  Integer isactive ;
	 
	   @OneToMany( fetch = FetchType.LAZY,mappedBy = "usuario")
private List<Phones> phoneList;
public Usuarios() {
	
}
public Usuarios(UUID id, String name, String email, String password) 
{
   super( );
   this.id = id;
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
	public List<Phones> getPhone() {
		return phoneList;
	}
	public void setPhone(List<Phones> phoneList) {
		this.phoneList = phoneList;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public java.util.Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(java.util.Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public java.util.Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(java.util.Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public java.util.Date getLast_login() {
		return last_login;
	}
	public void setLast_login(java.util.Date last_login) {
		this.last_login = last_login;
	}

	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public List<Phones> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<Phones> phoneList) {
		this.phoneList = phoneList;
	}

	
	
}
