package com.example.usuario.reposositorio;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usuario.model.Phones;

public interface PhoneRepository extends JpaRepository<Phones, Integer> {
	public List<Phones> findAllPhones();
	public void savePhone(Phones phones);
	public Phones findNumberPhone(UUID id,Integer number);
}
