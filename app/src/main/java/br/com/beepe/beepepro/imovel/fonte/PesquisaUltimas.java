package br.com.beepe.beepepro.imovel.fonte;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import br.com.beepe.beepepro.R;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaUltimasEnvio;
import br.com.beepe.beepepro.retrofit.*;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaUltimasRetorno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesquisaUltimas extends Fragment
{
	private Context context;
	private RecyclerView lista;
	private br.com.beepe.beepepro.imovel.adaptador.PesquisaUltimas adaptador;
	private String sessaoId;

	public PesquisaUltimas()
	{

	}
	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		this.context	= context;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_imovel_pesquisa_ultima, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		Bundle bundle	= getArguments();

		if(bundle != null)
		{
			sessaoId	= bundle.getString("SessaoId");
		}

		this.DefineLista();
		this.PesquisaDisponivel();
	}
	private void PesquisaDisponivel()
	{
		PesquisaUltimasEnvio parametros	= new PesquisaUltimasEnvio(this.sessaoId);
		iServico service = Servico.CreateService(iServico.class);
		Call<List<PesquisaUltimasRetorno>> call	= service.ImovelPesquisaUltimosDisponiveis(parametros);

		call.enqueue
		(
		new Callback<List<PesquisaUltimasRetorno>>() {
			@Override
			public void onResponse(Call<List<PesquisaUltimasRetorno>> call, Response<List<PesquisaUltimasRetorno>> response)
			{
				if(response.isSuccessful())
				{
					if(response.body() != null)// && !response.body().isEmpty())
					{
						CarregaLista(response.body());
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
			public void onFailure(Call<List<PesquisaUltimasRetorno>> call, Throwable t)
			{
				Toast.makeText(context.getApplicationContext(), "Erro na chamada ao servidor.", Toast.LENGTH_SHORT).show();
			}
		}
		);
	}
	private void CarregaLista(List<PesquisaUltimasRetorno> imoveis)
	{
		for (PesquisaUltimasRetorno imovel : imoveis)
		{
			this.adaptador.itemInsere(imovel);
		}
	}
	private void DefineLista()
	{
		this.lista							= getView().findViewById(R.id.rvwImoveis);
		LinearLayoutManager lom	= new LinearLayoutManager(this.context);
		this.lista.setLayoutManager(lom);
		this.adaptador = new br.com.beepe.beepepro.imovel.adaptador.PesquisaUltimas(getActivity(), new ArrayList<>(0));
		this.lista.setAdapter(adaptador);
	}
}
