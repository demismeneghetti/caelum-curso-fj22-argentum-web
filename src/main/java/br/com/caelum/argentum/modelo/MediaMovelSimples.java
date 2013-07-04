package br.com.caelum.argentum.modelo;

public class MediaMovelSimples {

	public double calcula(int posicao, SerieTemporal serie) {

		double soma = 0.0;

		for (int i = posicao - 2; i <= posicao; i++) {
			Candlestick c = serie.getCandle(i);
			soma += c.getFechamento();
		}
		return soma / 3;

	}

}
