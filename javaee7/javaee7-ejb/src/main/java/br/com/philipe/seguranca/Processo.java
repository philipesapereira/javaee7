package br.com.philipe.seguranca;

import java.io.Serializable;

public class Processo implements Serializable{

	private static final long serialVersionUID = 7691780602718216080L;

	private String codigo;

	//GET SET
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Construtor.
	 * @param codigo
	 */
	public Processo(String codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * Construtor.
	 */
	public Processo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}