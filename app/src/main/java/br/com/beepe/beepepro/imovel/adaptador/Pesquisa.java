package br.com.beepe.beepepro.imovel.adaptador;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import br.com.beepe.beepepro.R;
import br.com.beepe.beepepro.imovel.persistencia.PesquisaRetorno;
import br.com.beepe.beepepro.imovel.visualizador.PesquisaItem;
import br.com.beepe.beepepro.utilitario.Imagem;

public class Pesquisa  extends RecyclerView.Adapter<PesquisaItem>
{
	private final List<PesquisaRetorno> itens;

	public Pesquisa(ArrayList itens)
	{
		this.itens	= itens;
	}
	@Override
	public PesquisaItem onCreateViewHolder(ViewGroup parent, int viewType)
	{
		return new PesquisaItem(LayoutInflater.from(parent.getContext())
		.inflate(R.layout.fragment_imovel_pesquisa_recyclerview_item, parent, false));
	}
	@Override
	public void onBindViewHolder(PesquisaItem holder, int position)
	{
		NumberFormat formato		= NumberFormat.getCurrencyInstance();
		Imagem imagem						= new Imagem();
		Bitmap bitmap						= null;
		String construcaoTotal	= null;

		construcaoTotal	= Float.toString(this.itens.get(position).getConstrucaoTotal());
		construcaoTotal	= String.format("%sm²", construcaoTotal);

		holder.bairro.setText(this.itens.get(position).getBairro());
		holder.cidadeUf.setText(String.format(Locale.getDefault(), "%s / %s", this.itens.get(position).getCidade(), this.itens.get(position).getUf()));
		holder.valor.setText(formato.format(this.itens.get(position).getValor()));
		holder.tipo.setText(this.itens.get(position).getTipo());
		holder.quartos.setText(Byte.toString(this.itens.get(position).getQuantidadeQuartos()));
		holder.garagem.setText(Byte.toString(this.itens.get(position).getQuantidadeGaragem()));
		holder.construcaototal.setText(construcaoTotal);

		try
		{
			bitmap	= imagem.Desserealiza(this.itens.get(position).getFoto().toString());
			holder.foto.setImageBitmap(bitmap);
		}
		catch (Exception e)
		{
			holder.foto.setImageBitmap(null);
		}
	}
	@Override
	public int getItemCount()
	{
		return this.itens != null ? this.itens.size() : 0;
	}
	public void itemInsere(PesquisaRetorno item)
	{
		this.itens.add(item);
		notifyItemInserted(getItemCount());
	}
}
