package br.com.beepe.beepepro.imovel.persistencia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PesquisaUltimasEnvio
{
	@SerializedName("GuidUsuario")
	@Expose
	private String guidUsuario;

	public PesquisaUltimasEnvio(String guidUsuario)
	{
		this.guidUsuario	= guidUsuario;
	}

	public void setGuidUsuario(String guidUsuario)
	{
		this.guidUsuario	= guidUsuario;
	}
	public String getGuidUsuario()
	{
		return this.guidUsuario;
	}
}
