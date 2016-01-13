/**
 * 
 */
package br.com.cams7.ideros.service;

import java.util.List;

import br.com.cams7.ideros.entity.EmailEntity;

/**
 * @author cesar
 *
 */
public interface EmailService {
	void salvar(EmailEntity email);

	void atualizar(EmailEntity email);

	void remover(EmailEntity email);

	void remover(Long id);

	List<EmailEntity> buscarTodos();
	
	EmailEntity buscarPorId(Long id);
}
