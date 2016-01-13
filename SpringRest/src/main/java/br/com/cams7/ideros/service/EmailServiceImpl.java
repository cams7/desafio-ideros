/**
 * 
 */
package br.com.cams7.ideros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cams7.ideros.entity.EmailEntity;
import br.com.cams7.ideros.repository.EmailRepository;

/**
 * @author cesar
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository repository;

	public EmailServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.cams7.ideros.EmailEndPoint#salvar(br.com.cams7.ideros.EmailBO)
	 */
	@Transactional
	@Override
	public void salvar(EmailEntity email) {
		getRepository().salvar(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.cams7.ideros.EmailEndPoint#atualizar(br.com.cams7.ideros.EmailBO)
	 */
	@Transactional
	@Override
	public void atualizar(EmailEntity email) {
		getRepository().atualizar(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.cams7.ideros.EmailEndPoint#remover(br.com.cams7.ideros.EmailBO)
	 */
	@Transactional
	@Override
	public void remover(EmailEntity email) {
		getRepository().remover(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailEndPoint#remover(java.lang.Long)
	 */
	@Transactional
	@Override
	public void remover(Long id) {
		getRepository().remover(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailEndPoint#buscarTodos()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<EmailEntity> buscarTodos() {
		return getRepository().buscarTodos();
	}

	@Transactional(readOnly = true)
	@Override
	public EmailEntity buscarPorId(Long id) {
		return getRepository().buscarPorId(id);
	}

	private EmailRepository getRepository() {
		return repository;
	}

}
