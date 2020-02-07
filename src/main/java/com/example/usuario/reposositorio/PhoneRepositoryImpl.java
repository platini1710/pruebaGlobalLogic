package com.example.usuario.reposositorio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.model.Phones;
import com.example.usuario.model.Usuarios;
@Component
@Transactional  
public class PhoneRepositoryImpl  implements PhoneRepository{
	  @PersistenceContext
	  EntityManager entityManager; 

	@Override
	public List<Phones> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phones> findAllPhones() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Phones>  listPhones=entityManager.createQuery(
                "SELECT p FROM Phones  p ").getResultList();

		return listPhones;
	}

	@Override
	public List<Phones> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phones> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Phones> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Phones> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Phones getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phones> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phones> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Phones> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phones> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Phones> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Phones entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Phones> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Phones> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phones> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Phones> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Phones> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<Phones> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public void savePhone(Phones phones) {
		// TODO Auto-generated method stub


			// TODO Auto-generated method stub
			  entityManager.persist(phones);

		
	}

	@Override
	public Phones findNumberPhone(UUID id,Integer number) {
		// TODO Auto-generated method stub
		Phones  phone=null;
		 phone=(Phones)entityManager.createQuery(
                "SELECT p FROM Phones  p  where p.idPhone.number=:number and p.iduser=:iduser").setParameter("number", number).setParameter("iduser", id).getSingleResult();

		return phone;
	}

}
