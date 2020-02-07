package com.example.usuario.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.entity.PhonesDTO;
import com.example.usuario.entity.UsuariosDTO;
import com.example.usuario.helper.Respuesta;
import com.example.usuario.model.Phones;
import com.example.usuario.model.Usuarios;
import com.example.usuario.reposositorio.PhoneRepository;
import com.example.usuario.reposositorio.UsuarioRepository;



@RestController

public class Controller {
	  @Autowired
    private  UsuarioRepository usuarioRepository;
	  @Autowired
	    private  PhoneRepository phoneRepository;
		private static final Logger logger = LoggerFactory.getLogger(Controller.class);
		   
		
	  @RequestMapping(method = RequestMethod.GET, value="/",	produces = { "application/json" })
		@ResponseBody
    public  List<UsuariosDTO> hello() {
		  UsuariosDTO usuariosDTO=new UsuariosDTO();
		   SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
		List<Usuarios> listaUsuario= usuarioRepository.findAllUser();
		if (listaUsuario!=null)
		  logger.info("listaUsuario" +listaUsuario.size());
		//phones.setUsuario(usuarios);
		List<UsuariosDTO> listaUsuarioDTO= new ArrayList<UsuariosDTO>();
		for(Usuarios  usuario:listaUsuario) {
			usuariosDTO=new UsuariosDTO();
			usuariosDTO.setEmail(usuario.getEmail());
			usuariosDTO.setName(usuario.getName());
			usuariosDTO.setPassword(usuario.getPassword());
			String fechaCreacion =newFormat.format(usuario.getFecha_creacion());
			usuariosDTO.setFechaCreacion(fechaCreacion);
			String fechaModificacion =newFormat.format(usuario.getFecha_modificacion());
			usuariosDTO.setFechaModificacion(fechaModificacion);
			String lastLogin =newFormat.format(usuario.getLast_login());
			usuariosDTO.setLast_login(lastLogin);
			usuariosDTO.setToken(usuario.getId());
			String isActive=usuario.getIsactive() ==1 ? "true" : "false";
			usuariosDTO.setIsActive(isActive);

			List<PhonesDTO> listaPhoneDTO= new ArrayList<PhonesDTO>();
			List<Phones> listPhone=usuario.getPhone();
			for(Phones  phones:listPhone) {
				PhonesDTO phonesDTO=new PhonesDTO();
				phonesDTO.setCitycode(phones.getCitycode());
				phonesDTO.setCountrycode(phones.getCountrycode());
				phonesDTO.setNumber(phones.getIdPhone().getNumber());
				listaPhoneDTO.add(phonesDTO);
			}
	
			usuariosDTO.setListPhone(listaPhoneDTO);
			listaUsuarioDTO.add(usuariosDTO);
		
		}
		  return listaUsuarioDTO;
    }
	  
		/**
		 * Update user response entity.
		 *
		 * @param producto the user id
		 * @return the response entity
		 * @throws ResourceNotFoundException the resource not found exception
		 */
		@PostMapping("/save")
		@ResponseBody
		public  ResponseEntity<Object> saveUsuario( @RequestBody Usuarios usuario) {
	
			  logger.info("saveUsuarios" );
			Respuesta response = new Respuesta();
			try {
				if (esEmailCorrecto(usuario.getEmail())==false) {
					response.setMsg("formato del correo no valido" );
					  return new ResponseEntity<Object>(response, HttpStatus.OK);
				}
				if (passwordCorrecto(usuario.getPassword())==false) {
					response.setMsg("formato de la password es no valido" );
					  return new ResponseEntity<Object>(response, HttpStatus.OK);
				}
				
				Usuarios user=usuarioRepository.findUserByEmail(usuario.getEmail());
				if (user!=null) {
					response.setMsg("El correo ya esta registrado" );
					  return new ResponseEntity<Object>(response, HttpStatus.OK);
				}				
				usuario.setFecha_creacion(new Date());
				usuario.setFecha_modificacion(new Date());
				usuario.setLast_login(new Date());
				usuario.setIsactive(1);
	
				usuarioRepository.saveUsuarios(usuario);
				for(Phones  phones:usuario.getPhone()) {
					  phones.setUsuario(usuario);
					  phoneRepository.savePhone(phones);
				}
				response.setMsg("ok");

			}  catch (Exception e) {

				response.setMsg("error :::" + e.getMessage());
			}
			  return new ResponseEntity<Object>(response, HttpStatus.OK);
		}

		private Exception Exception() {
			// TODO Auto-generated method stub
			return null;
		}

		private  boolean esEmailCorrecto(String email) {
		       
	        boolean valido = false;
	       
	        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
	        	      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
	   
	        Pattern pattern = Pattern.compile(emailPattern);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	           valido = true; 
	        }
			  logger.info("esEmailCorrecto :::" +matcher.matches() );
	        return valido;
	    }	

		private  boolean passwordCorrecto(String passw) {
		       
	        boolean valido = false;
	        String pwdPattern =  "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}";
	        Pattern patronPwd = Pattern.compile(pwdPattern);
	   
	        Matcher pwd = patronPwd.matcher(passw);
	        if (pwd.matches()){
	           valido = true; 
	        }
			  logger.info("pwd :::" +pwd.matches() );
	        return valido;
	    }

		
}