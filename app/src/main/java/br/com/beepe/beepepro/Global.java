package br.com.beepe.beepepro;

import android.app.Application;

public class Global extends Application
{
	private String sessaoId;

	public String getSessaoId()
	{
		return this.sessaoId;
	}
	public void setSessaoId(String sessaoId)
	{
		this.sessaoId = sessaoId;
	}
}
