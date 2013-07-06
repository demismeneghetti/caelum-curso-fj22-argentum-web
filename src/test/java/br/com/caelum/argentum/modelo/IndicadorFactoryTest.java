package br.com.caelum.argentum.modelo;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;

public class IndicadorFactoryTest {

	@Test
	public void testMontaAbertura() {
		String nomeIndicador = "IndicadorAbertura";

		IndicadorFactory indicadorFactory = new IndicadorFactory(nomeIndicador,
				null);

		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof IndicadorAbertura);

	}

	@Test
	public void testMontaAberturaComMediaMovelSimples() {
		String nomeIndicador = "IndicadorAbertura";

		String nomeMedia = "MediaMovelSimples";

		IndicadorFactory indicadorFactory = new IndicadorFactory(nomeIndicador,
				nomeMedia);

		Indicador indicador = indicadorFactory.getIndicador();

		Assert.assertTrue(indicador instanceof MediaMovelSimples);

	}

}
