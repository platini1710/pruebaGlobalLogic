package com.example.usuario.reposositorio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.model.Usuarios;
@Component

@Transactional  
public class UsuarioRepositoryImpl implements UsuarioRepository{

	
	  @PersistenceContext
	  EntityManager entityManager; 

	
		@Override
		public Usuarios findUserByEmail(String email) {
			// TODO Auto-generated method stub
			Usuarios  usuario=null;
			// TODO Auto-generated method stub
			try {
			 usuario=(Usuarios)entityManager.createQuery(
	                "SELECT p FROM Usuarios  p  where p.email=:email").setParameter("email", email).getSingleResult();
			}catch(Exception e){
				 usuario=null;
			}
			return usuario;
		}


		public List<Usuarios> findAllUser(){
			// TODO Auto-generated method stub
			List<Usuarios>  usuarios=entityManager.createQuery(
	                "SELECT p FROM Usuarios  p ").getResultList();

			return usuarios;
		}
	

		@Override
		public List<Usuarios> findAll() {

			return null;
		}

		@Override
		public List<Usuarios> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Usuarios> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Usuarios> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Usuarios> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteInBatch(Iterable<Usuarios> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Usuarios getOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Usuarios> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Usuarios> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Usuarios> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Usuarios> S save(S entity) {
			// TODO Auto-generated method stub

			return null;
		}

		@Override
		@Transactional
		public void saveUsuarios(Usuarios usuarios) {
			// TODO Auto-generated method stub
			
			  entityManager.persist(usuarios);

		}
		@Override
		public Optional<Usuarios> findById(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void deleteById(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Usuarios entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends Usuarios> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Usuarios> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Usuarios> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Usuarios> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Usuarios> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
}
