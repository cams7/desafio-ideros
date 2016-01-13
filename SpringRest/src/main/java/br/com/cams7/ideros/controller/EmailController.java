/**
 * 
 */
package br.com.cams7.ideros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cams7.ideros.entity.EmailEntity;
import br.com.cams7.ideros.service.EmailService;

/**
 * 
 * 
 * @author cesar
 *
 */
@RestController
@RequestMapping(value = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailController {

	@Autowired
	private EmailService service;

	/**
	 * Busca todos os e-mais
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EmailEntity>> getEmails() {
		List<EmailEntity> emails = service.buscarTodos();
		if (emails.isEmpty())
			return new ResponseEntity<List<EmailEntity>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<EmailEntity>>(emails, HttpStatus.OK);
	}

	/**
	 * Busca apenas um e-mail
	 * 
	 * @param id
	 *            - Id do e-mail
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmailEntity> getEmail(@PathVariable("id") Long id) {
		EmailEntity email = service.buscarPorId(id);
		if (email == null)
			return new ResponseEntity<EmailEntity>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<EmailEntity>(email, HttpStatus.OK);
	}

	/**
	 * Cria um novo e-mail
	 * 
	 * @param email
	 *            - Entidade email
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrarEmail(@RequestBody EmailEntity email, UriComponentsBuilder ucBuilder) {

		// if (service.isUserExist(user))
		// return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		service.salvar(email);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/email/{id}").buildAndExpand(email.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Altera os dados do e-mail
	 * 
	 * @param id
	 *            - Id do e-mail
	 * @param email
	 *            - Entidade email
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmailEntity> alterarEmail(@PathVariable("id") Long id, @RequestBody EmailEntity email) {
		EmailEntity emailBuscado = service.buscarPorId(id);

		if (emailBuscado == null)
			return new ResponseEntity<EmailEntity>(HttpStatus.NOT_FOUND);

		emailBuscado.setFrom(email.getFrom());
		emailBuscado.setDatetime(email.getDatetime());
		emailBuscado.setSubject(email.getSubject());
		emailBuscado.setMessage(email.getMessage());
		emailBuscado.setUnread(email.isUnread());

		service.atualizar(emailBuscado);
		return new ResponseEntity<EmailEntity>(emailBuscado, HttpStatus.OK);
	}

	/**
	 * Remove o e-mail
	 * 
	 * @param id
	 *            - Id do e-mail
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmailEntity> excluirEmail(@PathVariable("id") Long id) {
		EmailEntity user = service.buscarPorId(id);
		if (user == null)
			return new ResponseEntity<EmailEntity>(HttpStatus.NOT_FOUND);

		service.remover(id);
		return new ResponseEntity<EmailEntity>(HttpStatus.NO_CONTENT);
	}

}
