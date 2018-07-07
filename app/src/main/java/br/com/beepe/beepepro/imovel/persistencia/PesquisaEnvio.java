package br.com.beepe.beepepro.imovel.persistencia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PesquisaEnvio
{
	@SerializedName("GuidUsuario")
	@Expose
	private String sessaoId;
	@SerializedName("PesquisaPersistenciaTelaPesquisa")
	@Expose
	private PesquisaItens itens;

	public PesquisaEnvio(String sessaoId, PesquisaItens itens)
	{
		this.sessaoId	= sessaoId;
		this.itens		= itens;
	}

	public void setSessaoId(String sessaoId)
	{
		this.sessaoId	= sessaoId;
	}
	public String getSessaoId()
	{
		return this.sessaoId;
	}
	public void setItens(PesquisaItens itens)
	{
		this.itens	= itens;
	}
	public PesquisaItens getItens()
	{
		return this.itens;
	}
}
