package br.com.beepe.beepepro.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servico
{
	// Endereço de produção
	//private static final String _url	= "https://beepe.azurewebsites.net/";
	// Endereço de produção
	private static final String _url	= "https://beepehomologacao.azurewebsites.net/";

	public static <S> S CreateService(Class<S> serviceClass)
	{
		HttpLoggingInterceptor loggingInterceptor	= new HttpLoggingInterceptor();
		OkHttpClient.Builder httpClient						= new OkHttpClient.Builder().readTimeout((long)15, TimeUnit.SECONDS);
		Gson gson;
		Retrofit retrofit;

		gson			= new GsonBuilder()
		.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
		.create();
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		httpClient.addInterceptor(loggingInterceptor);
		retrofit	= new Retrofit.Builder()
		.baseUrl(_url)
		.addConverterFactory(GsonConverterFactory.create(gson))
		.client(httpClient.build())
		.build();

		return retrofit.create(serviceClass);
	}
}
