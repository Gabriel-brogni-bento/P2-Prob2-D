package problema2;

import org.junit.jupiter.api.Test;

class ContaCorrenteTest {

	@Test
	void testCriaContaPessoaFisica() {
		ClientePessoaFisica pessoaFisica = new ClientePessoaFisica("Luis", "123", "123123", "1234");
		
		ContaCorrente contaFisica = new ContaCorrente(1, 2);
		
		pessoaFisica.addConta(contaFisica);
		
		pessoaFisica.setTipoServico(TipoServico.Notificacao);
		pessoaFisica.setTipoNotificacao(TipoNotificacao.WhatsApp);
		pessoaFisica.setTipoNotificacao(TipoNotificacao.SMS);
		
		pessoaFisica.setTipoServico(TipoServico.AnaliseFluxoCaixa);
		
		/////////////
		
		ClientePessoaJuridica pessoaJuridica = new ClientePessoaJuridica("Empresa", "321", "321321", "4321", "SERVER");
		
		ContaCorrente contaJuridica = new ContaCorrente(2, 2);
		
		pessoaJuridica.addConta(contaJuridica);
		
		pessoaJuridica.setTipoServico(TipoServico.Notificacao);
		pessoaJuridica.setTipoNotificacao(TipoNotificacao.JMS);
		
		contaFisica.depositar(100);
		contaFisica.sacar(10);
		
		contaJuridica.depositar(1000);
		
		contaJuridica.transferir(500, contaFisica);
	}
}
