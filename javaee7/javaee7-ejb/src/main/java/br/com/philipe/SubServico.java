package br.com.philipe;

import javax.annotation.ManagedBean;
import javax.enterprise.inject.Alternative;

@Alternative
@ManagedBean
public class SubServico implements ISubServico{

	private static final long serialVersionUID = -2136436365357388434L;

	@Override
	public String getMensagem() {
		return "SubServico.getMensagem()";
	}

}
