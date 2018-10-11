package test;

import org.junit.Test;

import enums.TipoNotificacao;
import enums.TipoServico;
import problema2.ClientePessoaFisica;
import problema2.ClientePessoaJuridica;
import problema2.ContaCorrente;

public class ContaCorrenteTest {

	@Test
	public void testCriaContaPessoaFisica() {
		ClientePessoaFisica pessoaFisica = new ClientePessoaFisica("Luis", "123", "123123", "1234");
		
		ContaCorrente contaFisica = new ContaCorrente(1, 2);
		
		pessoaFisica.addConta(contaFisica);
		
		pessoaFisica.addServico(TipoServico.Notificacao);
		pessoaFisica.addNotificacao(TipoNotificacao.WhatsApp);
		pessoaFisica.addNotificacao(TipoNotificacao.SMS);
		
		pessoaFisica.addServico(TipoServico.AnaliseFluxoCaixa);
		pessoaFisica.addServico(TipoServico.AnaliseInvestimento);
		
		pessoaFisica.removeServico(TipoServico.AnaliseInvestimento);
		
		contaFisica.depositar(100);
		
		contaFisica.sacar(10);
		
		pessoaFisica.removeNotificacao(TipoNotificacao.SMS);
		contaFisica.sacar(10);
		
		/////////////
		
		ClientePessoaJuridica pessoaJuridica = new ClientePessoaJuridica("Empresa", "321", "321321", "4321", "SERVER");
		
		ContaCorrente contaJuridica = new ContaCorrente(2, 2);
		
		pessoaJuridica.addConta(contaJuridica);
		
		pessoaJuridica.addServico(TipoServico.Notificacao);
		pessoaJuridica.addNotificacao(TipoNotificacao.JMS);
		
		/////////////////////
		
		contaFisica.depositar(100);
		contaFisica.sacar(10);
		
		contaJuridica.depositar(1000);
		
		contaJuridica.transferir(500, contaFisica);
		
		
		
		contaJuridica.depositar(10);
		contaFisica.depositar(10);
		contaJuridica.depositar(10);
		contaFisica.depositar(10);
	}
}
