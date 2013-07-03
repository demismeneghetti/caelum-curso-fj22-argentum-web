package br.com.caelum.argentum.ws;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class ClienteWebServiceTest {

    @Test
    public void testaWebService() {

        ClienteWebService ws = new ClienteWebService();
        List<Negociacao> negociacoes = ws.getNegociacoes();
       
        Assert.assertNotNull(negociacoes);
    }
}
