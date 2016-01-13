/**
 * 
 */
package br.com.cams7.ideros.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cams7.ideros.entity.EmailEntity;

/**
 * @author cesar
 *
 */
@Repository
public class EmailRepositoryImpl implements EmailRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public EmailRepositoryImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailDAO#salvar(br.com.cams7.ideros.EmailBO)
	 */
	@Override
	public void salvar(EmailEntity email) {
		getCurrentSession().save(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailDAO#atualizar(br.com.cams7.ideros.EmailBO)
	 */
	@Override
	public void atualizar(EmailEntity email) {
		getCurrentSession().update(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailDAO#remover(br.com.cams7.ideros.EmailBO)
	 */
	@Override
	public void remover(EmailEntity email) {
		getCurrentSession().delete(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailDAO#remover(java.lang.Long)
	 */
	@Override
	public void remover(Long id) {
		EmailEntity email = buscarPorId(id);
		if (email != null)
			remover(email);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.ideros.EmailDAO#buscarTodos()
	 */
	@Override
	public List<EmailEntity> buscarTodos() {
		@SuppressWarnings("unchecked")
		List<EmailEntity> emails = getCurrentSession().createCriteria(EmailEntity.class).list();
		return emails;
	}

	@Override
	public EmailEntity buscarPorId(Long id) {
		EmailEntity email = (EmailEntity) getCurrentSession().get(EmailEntity.class, id);
//		EmailBO email = (EmailBO) getCurrentSession().load(EmailBO.class, id);
		return email;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
