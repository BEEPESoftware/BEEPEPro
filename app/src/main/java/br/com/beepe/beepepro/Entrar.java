package br.com.beepe.beepepro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.beepe.beepepro.entrar.persistencia.EntrarEnvio;
import br.com.beepe.beepepro.retrofit.Servico;
import br.com.beepe.beepepro.retrofit.iServico;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Entrar extends AppCompatActivity //implements LoaderCallbacks<Cursor>
{
	private EditText mEmailView;
	private EditText mPasswordView;
	private View mProgressView;
	private View mLoginFormView;
	View focoView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrar);

		this.mEmailView			= (EditText) findViewById(R.id.txtEmail);
		this.mPasswordView	= (EditText) findViewById(R.id.txtSenha);
		this.mLoginFormView	= findViewById(R.id.svForm);
		this.mProgressView	= findViewById(R.id.pbEntrar);
	}
	public void ProcessandoEntrar(View view)
	{
		// Reset errors.
		this.mEmailView.setError(null);
		this.mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		String email			= this.mEmailView.getText().toString();
		String senha			= this.mPasswordView.getText().toString();
		boolean cancelar	= false;

		cancelar	= this.SenhaValida(senha, cancelar);
		cancelar = this.EmailValido(email, cancelar);

		if (cancelar)
		{
			focoView.requestFocus();
		}
		else
		{
			ProgressoMostrar(true);
			this.SessaoIdPega(email, senha);
		}
	}
	private boolean SenhaValida(String Senha, boolean cancelar)
	{
		if (TextUtils.isEmpty(Senha))// && !SenhaValida(password))
		{
			this.mPasswordView.setError(getString(R.string.error_field_required));
			this.focoView	= mPasswordView;
			cancelar			= true;
		}

		return cancelar;
	}
//	private boolean SenhaValida(String Senha)
//	{
//		//TODO: Replace this with your own logic
//		return Senha.length() > 4;
//	}
	private boolean EmailValido(String email, boolean cancelar)
	{
		if (TextUtils.isEmpty(email))
		{
			this.mEmailView.setError(getString(R.string.error_field_required));
			focoView	= mEmailView;
			cancelar	= true;
		}
		else if (!EmailValido(email))
		{
			this.mEmailView.setError(getString(R.string.error_invalid_email));
			focoView	= mEmailView;
			cancelar	= true;
		}

		return cancelar;
	}
	private boolean EmailValido(String email)
	{
		return email.contains("@");
	}
	private void SessaoIdPega(String Usuario, String Senha)
	{
		EntrarEnvio login	= new EntrarEnvio(Usuario, Senha, (byte)3);
		iServico service	= Servico.CreateService(iServico.class);
		Call<String> call	= service.Entrar(login);

		call.enqueue
		(
			new Callback<String>()
			{
				@Override
				public void onResponse(Call<String> call, Response<String> response)
				{
					ProgressoMostrar(false);

					if(response.isSuccessful())
					{
						if(response.body() != null && !response.body().isEmpty())
						{
//							((Global)getApplication()).setSessaoId(response.body());
//							ImovelPesquisaActivityVai();
							Intent intent	= new Intent(Entrar.this, Principal.class);
							intent.putExtra("SessaoId", response.body());
							startActivity(intent);
						}
						else
						{
							Toast.makeText(getApplicationContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
						}
					}
					else
					{
						mPasswordView.setError(getString(R.string.error_incorrect_password));
						mPasswordView.requestFocus();
						Toast.makeText(getApplicationContext(), "Resposta inválida " + response.message() + " " + response.code(), Toast.LENGTH_SHORT).show();
						//ResponseBody errorBody	= response.errorBody();
					}
				}
				@Override
				public void onFailure(Call<String> call, Throwable t)
				{
					ProgressoMostrar(false);
					Toast.makeText(getApplicationContext(), "Erro na chamada ao servidor.", Toast.LENGTH_SHORT).show();
				}
			}
		);
	}
	private void ProgressoMostrar(final boolean show)
	{
			int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

			this.mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
			this.mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter()
																																															{
																																																@Override
																																																public void onAnimationEnd(Animator animation)
																																																{
																																																	mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
																																																}
																																															}
																																															);

			this.mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
			this.mProgressView.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter()
																																															{
																																																@Override
																																																public void onAnimationEnd(Animator animation)
																																																{
																																																	mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
																																																}
																																															}
																																															);
	}
}
