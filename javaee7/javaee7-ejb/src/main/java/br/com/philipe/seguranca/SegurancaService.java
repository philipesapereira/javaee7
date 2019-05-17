package br.com.philipe.seguranca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.security.auth.message.AuthException;

@ManagedBean
public class SegurancaService implements ISegurancaService{

	private static final long serialVersionUID = 8146605197410268654L;

	private Map<String, UserLogin> userMap = new HashMap<String, UserLogin>();
	
	@PostConstruct
	private void init() {
		
		userMap.put("philipe", new UserLogin("philipe", "123"));
		userMap.put("teste", new UserLogin("teste", "123"));
		
	}
	
	@Override
	public User login(UserLogin login) throws AuthException {

		try {
			
			if(userMap.get(login.getUserName()).getPassword().equals(login.getPassword())) {
				
				User user = new User();
				user.setName(login.getUserName());
				
				return user;
			}

			throw new Exception();
			
		} catch (Exception e) {
			throw new AuthException("Usuario ou senha não encontrado");
		}
		
	}

	@Override
	public Set<Processo> listarProcessosAutorizados(User user) throws AuthException {
		
		if(null == user) {
			throw new AuthException("Usuario não informado");
		}
		
		System.out.println("SegurancaService.listarProcessosAutorizados()");
		
		Set<Processo> processos = new HashSet<Processo>();
		processos.add(new Processo("001"));
		processos.add(new Processo("002"));
		processos.add(new Processo("003"));
		
		
		return processos;
	}

}
