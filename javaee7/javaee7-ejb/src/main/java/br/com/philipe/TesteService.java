package br.com.philipe;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class TesteService implements ITesteService{

	private static final long serialVersionUID = -7731753554242698890L;

	@Inject
	private ISubServico subServico;
	
	@Override
	public String getMensagem() {
		// TODO Auto-generated method stub
		return "mensagem do service " + subServico.getMensagem();
	}

}
