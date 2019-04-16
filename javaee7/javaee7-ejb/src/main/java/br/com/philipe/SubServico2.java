package br.com.philipe;

import javax.annotation.ManagedBean;


@ManagedBean
public class SubServico2 implements ISubServico{

	private static final long serialVersionUID = -6022192326406330333L;

	@Override
	public String getMensagem() {
		return "SubServico.getMensagem() 2";
	}

}
