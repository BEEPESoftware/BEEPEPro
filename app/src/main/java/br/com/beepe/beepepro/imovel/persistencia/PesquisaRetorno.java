package br.com.beepe.beepepro.imovel.persistencia;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.Date;

public class PesquisaRetorno
{
	@SerializedName("ImovelRelacionamentoId")
	private int imovelRelacionamentoId;
	@SerializedName("Foto")
	private Object foto;
	@SerializedName("Tipo")
	private String tipo;
	@SerializedName("TransacaoTipo")
	private String transacaoTipo;
	@SerializedName("Codigo")
	private String codigo;
	@SerializedName("Endereco")
	private String endereco;
	@SerializedName("Bairro")
	private String bairro;
	@SerializedName("Cidade")
	private String cidade;
	@SerializedName("UF")
	private String uf;
	@SerializedName("QuantidadeQuartos")
	private byte quantidadeQuartos;
	@SerializedName("Banheiros")
	private byte banheiros;
	@SerializedName("QuantidadeGaragem")
	private byte quantidadeGaragem;
	@SerializedName("TerrenoTotal")
	private float terrenoTotal;
	@SerializedName("ConstrucaoTotal")
	private float construcaoTotal;
//	@SerializedName("Descricao")
//	private String descricao;
	@SerializedName("Observacao")
	private String observacao;
	@SerializedName("Valor")
	private BigDecimal valor;
	@SerializedName("ValorIptu")
	private BigDecimal valorIptu;
	@SerializedName("ValorCondominio")
	private BigDecimal valorCondominio;
	@SerializedName("ValorAgua")
	private BigDecimal valorAgua;
	@SerializedName("ValorEnergia")
	private BigDecimal valorEnergia;
	@SerializedName("DataCadastro")
	private Date dataCadastro;
	@SerializedName("DataAtualizacao")
	private Date dataAtualizacao;

	public PesquisaRetorno(int imovelRelacionamentoId, Object foto, String tipo, String transacaoTipo, String codigo, String endereco, String bairro, String cidade, String uf, byte QuantidadeQuartos, byte banheiros, byte QuantidadeGaragem, float TerrenoTotal, float ConstrucaoTotal, String observacao, BigDecimal valor, BigDecimal valorIptu, BigDecimal valorCondominio, BigDecimal valorAgua, BigDecimal valorEnergia, Date dataCadastro, Date dataAtualizacao)
	{
		this.imovelRelacionamentoId	= imovelRelacionamentoId;
		this.foto										= foto;
		this.tipo										= tipo;
		this.transacaoTipo					= transacaoTipo;
		this.codigo									= codigo;
		this.endereco								= endereco;
		this.bairro									= bairro;
		this.cidade									= cidade;
		this.uf											= uf;
		this.quantidadeQuartos			= QuantidadeQuartos;
		this.banheiros							= banheiros;
		this.quantidadeGaragem			= QuantidadeGaragem;
		this.terrenoTotal						= TerrenoTotal;
		this.construcaoTotal				= ConstrucaoTotal;
//		this.descricao							= descricao;
		this.observacao							= observacao;
		this.valor									= valor;
		this.valorIptu							= valorIptu;
		this.valorCondominio				= valorCondominio;
		this.valorAgua							= valorAgua;
		this.valorEnergia						= valorEnergia;
		this.dataCadastro						= dataCadastro;
		this.dataAtualizacao				= dataAtualizacao;
	}

	public void setImovelRelacionamentoId(int imovelRelacionamentoId)
	{
		this.imovelRelacionamentoId	= imovelRelacionamentoId;
	}
	public int getImovelRelacionamentoId()
	{
		return this.imovelRelacionamentoId;
	}
	public void setFoto(Object foto)
	{
		this.foto	= foto;
	}
	public Object getFoto()
	{
		return this.foto;
	}
	public void setTipo(String tipo)
	{
		this.tipo	= tipo;
	}
	public String getTipo()
	{
		return this.tipo;
	}
	public void setTransacaoTipo(String transacaoTipo)
	{
		this.transacaoTipo	= transacaoTipo;
	}
	public String getTransacaoTipo()
	{
		return transacaoTipo;
	}
	public void setCodigo(String codigo)
	{
		this.codigo	= codigo;
	}
	public String getCodigo()
	{
		return this.codigo;
	}
	public void setEndereco(String endereco)
	{
		this.endereco	= endereco;
	}
	public String getEndereco()
	{
		return this.endereco;
	}
	public void setBairro(String bairro)
	{
		this.bairro	= bairro;
	}
	public String getBairro()
	{
		return this.bairro;
	}
	public void setCidade(String cidade)
	{
		this.cidade	= cidade;
	}
	public String getCidade()
	{
		return this.cidade;
	}
	public void setUf(String uf)
	{
		this.uf	= uf;
	}
	public String getUf()
	{
		return this.uf;
	}
	public void setQuantidadeQuartos(byte quantidadeQuartos)
	{
		this.quantidadeQuartos	= quantidadeQuartos;
	}
	public byte getQuantidadeQuartos()
	{
		return this.quantidadeQuartos;
	}
	public void setBanheiros(byte banheiros)
	{
		this.banheiros = banheiros;
	}
	public byte getBanheiros()
	{
		return banheiros;
	}
	public void setQuantidadeGaragem(byte quantidadeGaragem)
	{
		this.quantidadeGaragem	= quantidadeGaragem;
	}
	public byte getQuantidadeGaragem()
	{
		return this.quantidadeGaragem;
	}
	public void setTerrenoTotal(float terrenoTotal)
	{
		this.terrenoTotal	= terrenoTotal;
	}
	public float getTerrenoTotal()
	{
		return this.terrenoTotal;
	}
	public void setConstrucaoTotal(float construcaoTotal)
	{
		this.construcaoTotal	= construcaoTotal;
	}
	public float getConstrucaoTotal()
	{
		return this.construcaoTotal;
	}
//	public void setDescricao(String descricao)
//	{
//		this.descricao	= descricao;
//	}
//	public String getDescricao()
//	{
//		return this.descricao;
//	}
	public void setObservacao(String observacao)
	{
		this.observacao	= observacao;
	}
	public String getObservacao()
	{
		return this.observacao;
	}
	public void setValor(BigDecimal valor)
	{
		this.valor	= valor;
	}
	public BigDecimal getValor()
	{
		return this.valor;
	}
	public void setValorIptu(BigDecimal valorIptu)
	{
		this.valorIptu	= valorIptu;
	}
	public BigDecimal getValorIptu()
	{
		return this.valorIptu;
	}
	public void setValorCondominio(BigDecimal valorCondominio)
	{
		this.valorCondominio	= valorCondominio;
	}
	public BigDecimal getValorCondominio()
	{
		return this.valorCondominio;
	}
	public void setValorAgua(BigDecimal valorAgua)
	{
		this.valorAgua	= valorAgua;
	}
	public BigDecimal getValorAgua()
	{
		return this.valorAgua;
	}
	public void setValorEnergia(BigDecimal valorEnergia)
	{
		this.valorEnergia	= valorEnergia;
	}
	public BigDecimal getValorEnergia()
	{
		return this.valorEnergia;
	}
	public void setDataCadastro(Date dataCadastro)
	{
		this.dataCadastro	= dataCadastro;
	}
	public Date getDataCadastro()
	{
		return this.dataCadastro;
	}
	public void setDataAtualizacao(Date dataAtualizacao)
	{
		this.dataAtualizacao	= dataAtualizacao;
	}
	public Date getDataAtualizacao()
	{
		return this.dataAtualizacao;
	}
}
