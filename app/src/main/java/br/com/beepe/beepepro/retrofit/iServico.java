package br.com.beepe.beepepro.retrofit;

import java.util.List;
import br.com.beepe.beepepro.entrar.persistencia.*;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaEnvio;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaRetorno;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaUltimasEnvio;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaUltimasRetorno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface iServico
{
	@POST("SegurancaUsuario/Login/")
	Call<String> Entrar(@Body EntrarEnvio Parametros);

	@POST("Pesquisa/PesquisaUltimosDisponiveis/")
	Call<List<PesquisaUltimasRetorno>> ImovelPesquisaUltimosDisponiveis(@Body PesquisaUltimasEnvio Parametos);

	@POST("Pesquisa/PesquisaDisponivel/")
	Call<List<PesquisaRetorno>> ImovelPesquisaDisponiveis(@Body PesquisaEnvio Parametros);
}
