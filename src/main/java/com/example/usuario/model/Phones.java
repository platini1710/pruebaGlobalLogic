package com.example.usuario.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Phones")
public class Phones {
	@EmbeddedId
	private PhoneId idPhone;

	private int citycode;
	private int countrycode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser", referencedColumnName = "id", nullable = false, updatable = true, insertable = true)
	private Usuarios usuario;

	public PhoneId getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(PhoneId idPhone) {
		this.idPhone = idPhone;
	}

	public int getCitycode() {
		return citycode;
	}

	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + citycode;
		result = prime * result + countrycode;
		result = prime * result + ((idPhone == null) ? 0 : idPhone.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phones other = (Phones) obj;
		if (citycode != other.citycode)
			return false;
		if (countrycode != other.countrycode)
			return false;
		if (idPhone == null) {
			if (other.idPhone != null)
				return false;
		} else if (!idPhone.equals(other.idPhone))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
