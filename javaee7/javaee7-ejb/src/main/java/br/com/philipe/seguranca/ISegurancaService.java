package br.com.philipe.seguranca;

import java.io.Serializable;
import java.util.Set;

import javax.security.auth.message.AuthException;

public interface ISegurancaService extends Serializable{

	User login(UserLogin login) throws AuthException;
	
	Set<Processo> listarProcessosAutorizados(User user) throws AuthException;
}
