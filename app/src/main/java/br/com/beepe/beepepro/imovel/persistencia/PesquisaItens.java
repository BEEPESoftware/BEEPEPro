package br.com.beepe.beepepro.imovel.persistencia;

import java.math.BigDecimal;

public class PesquisaItens
{
	private byte imovelRelacionamentoTipoId;
	private int intIdEntidade;
	private int clienteId;
	private byte imovelTransacaoTipoId;
	private String codigo;
	private Integer imovelTipoId;
	private BigDecimal valorInicial;
	private BigDecimal valorFinal;
	private String uf;
	private Short cidadeId;
	private String forro;
	private Integer quartos;
	private int suite;
	private int apartamento;
	private int convencional;
	private int dormEmpregado;
	private Integer salas;
	private int salaDeEstar;
	private int salaTvSom;
	private int salaJantar;
	private int salaJogos;
	private Integer garagem;
	private int garagemCoberta;
	private int garagemDescoberta;
	private Integer terrenoTotal;
	private Integer construcaoTotal;
	private int escritorio;
	private int lavabo;
	private int copa;
	private int despensa;
	private int despejo;
	private int varanda;
	private boolean churrasqueira;
	private boolean piscina;
	private boolean areaLazer;
	private boolean edicula;
	private boolean quiosque;
	private boolean alarme;
	private boolean armarioEmbutido;
	private boolean portaoEletronico;
	private boolean quintal;
	private int[] bairros;

	public PesquisaItens()
	{
		this.imovelRelacionamentoTipoId	= 1;
		this.intIdEntidade							= 123;
		this.clienteId									= 0;
		this.imovelTransacaoTipoId			= 1;
		this.codigo											= null;
		this.imovelTipoId								= null;
		this.valorInicial								= null;
		this.valorFinal									= null;
		this.uf													= null;
		this.cidadeId										= null;
		this.forro											= null;
		this.quartos										= null;
		this.suite											= 0;
		this.apartamento								= 0;
		this.convencional								= 0;
		this.dormEmpregado							= 0;
		this.salas											= null;
		this.salaDeEstar								= 0;
		this.salaTvSom									= 0;
		this.salaJantar									= 0;
		this.salaJogos									= 0;
		this.garagem										= null;
		this.garagemCoberta							= 0;
		this.garagemDescoberta					= 0;
		this.terrenoTotal								= null;
		this.construcaoTotal						= null;
		this.escritorio									= 0;
		this.lavabo											= 0;
		this.copa												= 0;
		this.despensa										= 0;
		this.despejo										= 0;
		this.varanda										= 0;
		this.churrasqueira							= false;
		this.piscina										= false;
		this.areaLazer									= false;
		this.edicula										= false;
		this.quiosque										= false;
		this.alarme											= false;
		this.armarioEmbutido						= false;
		this.portaoEletronico						= false;
		this.quintal										= false;
		this.bairros										= new int[]{};
	}

	public void setImovelRelacionamentoTipoId(byte imovelRelacionamentoTipoId)
	{
		this.imovelRelacionamentoTipoId = imovelRelacionamentoTipoId;
	}
	public byte getImovelRelacionamentoTipoId()
	{
		return this.imovelRelacionamentoTipoId;
	}
	public void setIntIdEntidade(int intIdEntidade)
	{
		this.intIdEntidade	= intIdEntidade;
	}
	public int getIntIdEntidade()
	{
		return this.intIdEntidade;
	}
	public void setClienteId(int clienteId)
	{
		this.clienteId = clienteId;
	}
	public int getClienteId()
	{
		return this.clienteId;
	}
	public void setImovelTransacaoTipoId(byte imovelTransacaoTipoId)
	{
		this.imovelTransacaoTipoId = imovelTransacaoTipoId;
	}
	public byte getImovelTransacaoTipoId()
	{
		return this.imovelTransacaoTipoId;
	}
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	public String getCodigo()
	{
		return this.codigo;
	}
	public void setImovelTipoId(Integer imovelTipoId)
	{
		this.imovelTipoId = imovelTipoId;
	}
	public int getImovelTipoId()
	{
		return this.imovelTipoId;
	}
	public void setValorInicial(BigDecimal valorInicial)
	{
		this.valorInicial = valorInicial;
	}
	public BigDecimal getValorInicial()
	{
		return this.valorInicial;
	}
	public void setValorFinal(BigDecimal valorFinal)
	{
		this.valorFinal = valorFinal;
	}
	public BigDecimal getValorFinal()
	{
		return this.valorFinal;
	}
	public void setUf(String uf)
	{
		this.uf = uf;
	}
	public String getUf()
	{
		return this.uf;
	}
	public void setCidadeId(short cidadeId)
	{
		this.cidadeId = cidadeId;
	}
	public short getCidadeId()
	{
		return this.cidadeId;
	}
	public void setForro(String forro)
	{
		this.forro = forro;
	}
	public String getForro()
	{
		return this.forro;
	}
	public void setQuartos(Integer quartos)
	{
		this.quartos = quartos;
	}
	public int getQuartos()
	{
		return this.quartos;
	}
	public void setSuite(int suite)
	{
		this.suite = suite;
	}
	public int getSuite()
	{
		return this.suite;
	}
	public void setApartamento(int apartamento)
	{
		this.apartamento = apartamento;
	}
	public int getApartamento()
	{
		return this.apartamento;
	}
	public void setConvencional(int convencional)
	{
		this.convencional = convencional;
	}
	public int getConvencional()
	{
		return this.convencional;
	}
	public void setDormEmpregado(int dormEmpregado)
	{
		this.dormEmpregado = dormEmpregado;
	}
	public int getDormEmpregado()
	{
		return this.dormEmpregado;
	}
	public void setSalas(Integer salas)
	{
		this.salas = salas;
	}
	public int getSalas()
	{
		return this.salas;
	}
	public void setSalaDeEstar(int salaDeEstar)
	{
		this.salaDeEstar = salaDeEstar;
	}
	public int getSalaDeEstar()
	{
		return this.salaDeEstar;
	}
	public void setSalaTvSom(int salaTvSom)
	{
		this.salaTvSom = salaTvSom;
	}
	public int getSalaTvSom()
	{
		return this.salaTvSom;
	}
	public void setSalaJantar(int salaJantar)
	{
		this.salaJantar = salaJantar;
	}
	public int getSalaJantar()
	{
		return this.salaJantar;
	}
	public void setSalaJogos(int salaJogos)
	{
		this.salaJogos = salaJogos;
	}
	public int getSalaJogos()
	{
		return this.salaJogos;
	}
	public void setGaragem(Integer garagem)
	{
		this.garagem = garagem;
	}
	public int getGaragem()
	{
		return this.garagem;
	}
	public void setGaragemCoberta(int garagemCoberta)
	{
		this.garagemCoberta = garagemCoberta;
	}
	public int getGaragemCoberta()
	{
		return this.garagemCoberta;
	}
	public void setGaragemDescoberta(int garagemDescoberta)
	{
		this.garagemDescoberta = garagemDescoberta;
	}
	public int getGaragemDescoberta()
	{
		return this.garagemDescoberta;
	}
	public void setTerrenoTotal(Integer terrenoTotal)
	{
		this.terrenoTotal = terrenoTotal;
	}
	public int getTerrenoTotal()
	{
		return this.terrenoTotal;
	}
	public void setConstrucaoTotal(Integer construcaoTotal)
	{
		this.construcaoTotal = construcaoTotal;
	}
	public int getConstrucaoTotal()
	{
		return this.construcaoTotal;
	}
	public void setEscritorio(int escritorio)
	{
		this.escritorio = escritorio;
	}
	public int getEscritorio()
	{
		return this.escritorio;
	}
	public void setLavabo(int lavabo)
	{
		this.lavabo = lavabo;
	}
	public int getLavabo()
	{
		return this.lavabo;
	}
	public void setCopa(int copa)
	{
		this.copa = copa;
	}
	public int getCopa()
	{
		return this.copa;
	}
	public void setDespensa(int despensa)
	{
		this.despensa = despensa;
	}
	public int getDespensa()
	{
		return this.despensa;
	}
	public void setDespejo(int despejo)
	{
		this.despejo = despejo;
	}
	public int getDespejo()
	{
		return this.despejo;
	}
	public void setVaranda(int varanda)
	{
		this.varanda = varanda;
	}
	public int getVaranda()
	{
		return this.varanda;
	}
	public void setChurrasqueira(boolean churrasqueira)
	{
		this.churrasqueira = churrasqueira;
	}
	public boolean getChurrasqueira()
	{
		return this.churrasqueira;
	}
	public void setPiscina(boolean piscina)
	{
		this.piscina = piscina;
	}
	public boolean getPiscina()
	{
		return this.piscina;
	}
	public void setAreaLazer(boolean areaLazer)
	{
		this.areaLazer = areaLazer;
	}
	public boolean getAreaLazer()
	{
		return this.areaLazer;
	}
	public void setEdicula(boolean edicula)
	{
		this.edicula = edicula;
	}
	public boolean getEdicula()
	{
		return this.edicula;
	}
	public void setQuiosque(boolean quiosque)
	{
		this.quiosque = quiosque;
	}
	public boolean getQuiosque()
	{
		return this.quiosque;
	}
	public void setAlarme(boolean alarme)
	{
		this.alarme = alarme;
	}
	public boolean getAlarme()
	{
		return this.alarme;
	}
	public void setArmarioEmbutido(boolean armarioEmbutido)
	{
		this.armarioEmbutido = armarioEmbutido;
	}
	public boolean getArmarioEmbutido()
	{
		return this.armarioEmbutido;
	}
	public void setPortaoEletronico(boolean portaoEletronico)
	{
		this.portaoEletronico = portaoEletronico;
	}
	public boolean getPortaoEletronico()
	{
		return this.portaoEletronico;
	}
	public void setQuintal(boolean quintal)
	{
		this.quintal = quintal;
	}
	public boolean getQuintal()
	{
		return this.quintal;
	}
	public void setBairros(int[] bairros)
	{
		this.bairros	= bairros;
	}
	public int[] getBairros()
	{
		return this.bairros;
	}
}
