package br.com.beepe.beepepro.imovel.fonte;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import br.com.beepe.beepepro.R;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaEnvio;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaItens;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaRetorno;
import br.com.beepe.beepepro.retrofit.Servico;
import br.com.beepe.beepepro.retrofit.iServico;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pesquisa extends Fragment
{
	private Context context;
	private View tlForm, flProgresso, rvImovel;
	private Button btnBusca;
	private RecyclerView lista;
	private br.com.beepe.beepepro.imovel.adaptador.Pesquisa adaptador;
	private String sessaoId;

	public Pesquisa()
	{
		// Required empty public constructor
	}
	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		this.context	= context;
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		Bundle bundle			= getArguments();
		View view					= inflater.inflate(R.layout.fragment_imovel_pesquisa, container, false);

		this.tlForm				= view.findViewById(R.id.llForm);
		this.flProgresso	= view.findViewById(R.id.flProgresso);
		this.rvImovel			= view.findViewById(R.id.rvImoveis);

		if(bundle != null)
		{
			sessaoId	= bundle.getString("SessaoId");
		}

		btnBusca	= (Button)view.findViewById(R.id.btnBuscar);
		btnBusca.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ExibirBarraProgresso();
				DefineLista();
				PesquisaDisponivel();
			}
		});

		return view;
	}
	@Override
	public void onDetach()
	{
		super.onDetach();
	}
	private void ExibirBarraProgresso()
	{
		int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

		this.tlForm.setVisibility(View.GONE);
		this.tlForm.animate().setDuration(shortAnimTime).alpha(0).setListener(new AnimatorListenerAdapter()
																																					{
																																						@Override
																																						public void onAnimationEnd(Animator animation)
																																						{
																																							tlForm.setVisibility(View.GONE);
																																						}
																																					}
																																					);

		this.flProgresso.setVisibility(View.VISIBLE);
		this.flProgresso.animate().setDuration(shortAnimTime).alpha(1).setListener(new AnimatorListenerAdapter()
																																							{
																																								@Override
																																								public void onAnimationEnd(Animator animation)
																																								{
																																									flProgresso.setVisibility(View.VISIBLE);
																																								}
																																							}
																																							);
	}
	private void ExibirImoveis()
	{
		int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

		this.flProgresso.setVisibility(View.GONE);
		this.flProgresso.animate().setDuration(shortAnimTime).alpha(0).setListener(new AnimatorListenerAdapter()
																																					{
																																						@Override
																																						public void onAnimationEnd(Animator animation)
																																						{
																																							flProgresso.setVisibility(View.GONE);
																																						}
																																					}
		);

		this.rvImovel.setVisibility(View.VISIBLE);
		this.rvImovel.animate().setDuration(shortAnimTime).alpha(1).setListener(new AnimatorListenerAdapter()
																																							 {
																																								 @Override
																																								 public void onAnimationEnd(Animator animation)
																																								 {
																																									 rvImovel.setVisibility(View.VISIBLE);
																																								 }
																																							 }
		);
	}
	private void PesquisaDisponivel()
	{
		PesquisaEnvio parametros					= new PesquisaEnvio(this.sessaoId, FiltroCarrega());
		iServico service									= Servico.CreateService(iServico.class);
		Call<List<PesquisaRetorno>> call	= service.ImovelPesquisaDisponiveis(parametros);

		call.enqueue
		(
		new Callback<List<PesquisaRetorno>>() {
			@Override
			public void onResponse(Call<List<PesquisaRetorno>> call, Response<List<PesquisaRetorno>> response)
			{
				if(response.isSuccessful())
				{
					if(response.body() != null)// && !response.body().isEmpty())
					{
						CarregaLista(response.body());
						ExibirImoveis();
					}
					else
					{
						Toast.makeText(context.getApplicationContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					Toast.makeText(context.getApplicationContext(), "Resposta inválida " + response.message() + " " + response.code(), Toast.LENGTH_SHORT).show();
					//ResponseBody errorBody	= response.errorBody();
				}
			}
			@Override
			public void onFailure(Call<List<PesquisaRetorno>> call, Throwable t)
			{
				Toast.makeText(context.getApplicationContext(), "Erro na chamada ao servidor.", Toast.LENGTH_SHORT).show();
			}
		}
		);
	}
	private PesquisaItens FiltroCarrega()
	{
		PesquisaItens filtro	= new PesquisaItens();

		return filtro;
	}
	private void CarregaLista(List<PesquisaRetorno> imoveis)
	{
		for (PesquisaRetorno imovel : imoveis)
		{
			this.adaptador.itemInsere(imovel);
		}
	}
	private void DefineLista()
	{
		this.lista							= getView().findViewById(R.id.rvImoveis);
		LinearLayoutManager lom	= new LinearLayoutManager(this.context);
		this.lista.setLayoutManager(lom);
		this.adaptador					= new br.com.beepe.beepepro.imovel.adaptador.Pesquisa(new ArrayList<>(0));
		this.lista.setAdapter(adaptador);
	}
}
