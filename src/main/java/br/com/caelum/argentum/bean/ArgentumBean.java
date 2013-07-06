package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean {

	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String titulo;

	public ChartModel getModeloGrafico() {

		return modeloGrafico;

	}

	public void preparaDados() {
		
		System.out.println("[LOG] Executando método preparaDados...");

		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();

		List<Candle> candles = new CandlestickFactory()
				.constroiCandles(this.negociacoes);

		SerieTemporal serie = new SerieTemporal(candles);

		GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 2,
				serie.getTotal() - 1);
		gerador.plotaIndicador(new MediaMovelSimples(new IndicadorAbertura()));
		gerador.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
		gerador.plotaIndicador(new MediaMovelPonderada(new IndicadorAbertura()));
		gerador.plotaIndicador(new MediaMovelPonderada(new IndicadorFechamento()));
		
		this.modeloGrafico = gerador.getModeloGrafico();

	}

	public List<Negociacao> getNegociacoes() {

		return negociacoes;

	}


	public String getTitulo() {
	
		return titulo;
	
	}

	public void setTitulo(String titulo) {
	
		this.titulo = titulo;

	}


}
