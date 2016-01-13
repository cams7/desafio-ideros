/**
 * 
 */
package br.com.cams7.ideros.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author cesar
 *
 */
@Entity
@Table(name = "email")
public class EmailEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_email")
	@GeneratedValue
	private Long id;

	@Column(name = "de")
	private String from;

	@Column(name = "envio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	@Column(name = "assunto")
	private String subject;

	@Column(name = "mensagem")
	private String message;

	@Column(name = "lido")
	private boolean unread;

	public EmailEntity() {
		super();
	}

	/**
	 * @param id
	 */
	public EmailEntity(Long id) {
		this();

		setId(id);
	}

	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}

}
