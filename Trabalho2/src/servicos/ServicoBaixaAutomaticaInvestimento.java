package servicos;

import enums.TipoOperacao;
import interfaces.IServico;

public class ServicoBaixaAutomaticaInvestimento implements IServico {

	@Override
	public void executarServico(String infoCliente, TipoOperacao tipo) {
		System.out.print(infoCliente);
		System.out.println("fazendo baixa automatica de investimentos");
	}
	
	@Override
	public boolean podeExecutar(TipoOperacao tipo) {
		return true;
	}

}
