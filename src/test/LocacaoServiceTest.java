package test;
import java.util.Date;

import org.junit.Test;

import org.junit.Assert;

import qts.locador.exception.JogoSemEstoqueException;
import qts.locadora.Cliente;
import qts.locadora.Jogo;
import qts.locadora.Locacao;
import qts.locadora.service.LocacaoService;
import qts.locadora.util.DataUtil;
public class LocacaoServiceTest {
	@Test
	public void teste() throws Exception{
		Cliente cliente = new Cliente("Antonio");
		Jogo jogo = new Jogo("Harry Potter", 15.00, 2);
		
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao; 
		
		
		locacao = locacaoService.alugarJogo(cliente, jogo);
		
		Assert.assertTrue(locacao.getJogo().getNome().equals(jogo.getNome()));
		Assert.assertTrue(locacao.getCliente().getNome().equals(cliente.getNome()));
		Assert.assertTrue("Erro no valor do jogo", locacao.getValor()==jogo.getValor());
		
	}
	
	@Test (expected = JogoSemEstoqueException.class)
	public void testSemEstoquee() throws Exception{
		Cliente cliente = new Cliente("Antonio");
		Jogo jogo = new Jogo("Harry Potter", 15.00, 0);
		
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;
		locacao = locacaoService.alugarJogo(cliente,jogo);
		
	}
	
	@Test (expected = Exception.class)
	public void testSemValor() throws Exception{
		Cliente cliente = new Cliente("Antonio");
		Jogo jogo = new Jogo("Harry Potter",00.00, 1);
		
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao;
		locacao = locacaoService.alugarJogo(cliente,jogo);
		
	}
	
}
