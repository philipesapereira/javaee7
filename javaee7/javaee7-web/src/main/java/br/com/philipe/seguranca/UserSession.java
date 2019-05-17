package br.com.philipe.seguranca;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

@ManagedBean
public class UserSession implements Serializable{

	private static final long serialVersionUID = 2940701696325967869L;
	
	private static String USER = "USER";
	private static String PROCESSOS = "PROCESSOS";
	
	@Inject private HttpServletRequest request;
	@Inject	private ISegurancaService segurancaService;
	
	private HttpSession getSession() {
		return this.request.getSession(true);
	}

	public User getUser() {
		return (User) this.getSession().getAttribute(USER);
	}

	public void setUser(User user) {
		this.getSession().setAttribute(USER, user);
		this.getSession().setAttribute(PROCESSOS, null);
	}
	
	public Set<Processo> listarProcessosAutorizados() throws AuthException{
		
		if(null == this.getSession().getAttribute(PROCESSOS)) {
			try {
				this.getSession().setAttribute(PROCESSOS, this.segurancaService.listarProcessosAutorizados(this.getUser()));
			} catch (Exception e) {
				this.getSession().setAttribute(PROCESSOS,null);
				throw new AuthException(e.getMessage());
			}
		}
		
		return (Set<Processo>) this.getSession().getAttribute(PROCESSOS);
	}
	
	
}