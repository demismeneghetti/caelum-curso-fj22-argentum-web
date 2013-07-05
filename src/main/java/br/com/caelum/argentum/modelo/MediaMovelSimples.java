package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class MediaMovelSimples implements Indicador {

	public double calcula(int posicao, SerieTemporal serie) {

		double soma = 0.0;

		for (int i = posicao - 2; i <= posicao; i++) {
			soma += serie.getCandle(i).getFechamento();
		}
		return soma / 3;

	}

	@Override
	public String toString() {

		return "MMS de Fechamento";

	}

}
