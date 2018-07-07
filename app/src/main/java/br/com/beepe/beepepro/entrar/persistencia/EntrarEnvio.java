package br.com.beepe.beepepro.entrar.persistencia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EntrarEnvio
{
	@SerializedName("Email")
	@Expose
	private String mail;
	@SerializedName("Senha")
	@Expose
	private String senha;
	@SerializedName("SegurancaUsuarioSessaoTipoId")
	@Expose
	private byte sessaoTipoId;

	public EntrarEnvio(String mail, String senha, byte sessaoTipoId)
	{
		this.mail					= mail;
		this.senha				= senha;
		this.sessaoTipoId	= sessaoTipoId;
	}

	public void setMail(String mail)
	{
		this.mail	= mail;
	}
	public String getMail()
	{
		return this.mail;
	}
	public void setSenha(String senha)
	{
		this.senha	= senha;
	}
	public String getSenha()
	{
		return this.senha;
	}
	public void setSessaoTipoId(byte sessaoTipoId)
	{
		this.sessaoTipoId = sessaoTipoId;
	}
	public byte getSessaoTipoId()
	{
		return this.sessaoTipoId;
	}
}
