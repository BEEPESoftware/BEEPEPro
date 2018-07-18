package br.com.beepe.beepepro.imovel.visualizador;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.beepe.beepepro.R;

public class PesquisaItem extends RecyclerView.ViewHolder
{
	public TextView bairro, cidadeUf, valor, tipo, quartos, garagem, construcaototal;
	public ImageView foto;
	public CardView cardView;

	public PesquisaItem(View itemView)
	{
		super(itemView);
		bairro					= (TextView)itemView.findViewById(R.id.txtBairro);
		cidadeUf				= (TextView) itemView.findViewById(R.id.txtCidadeUf);
		valor						= (TextView)itemView.findViewById(R.id.txtValor);
		foto						= (ImageView)itemView.findViewById(R.id.imgImovel);
		tipo						= (TextView)itemView.findViewById(R.id.txtTipo);
		quartos					= (TextView)itemView.findViewById(R.id.txtQuartos);
		garagem					= (TextView)itemView.findViewById(R.id.txtGaragem);
		construcaototal	= (TextView)itemView.findViewById(R.id.txtConstrucaoTotal);
		cardView	= (CardView) itemView.findViewById(R.id.card_view);

	}
}
