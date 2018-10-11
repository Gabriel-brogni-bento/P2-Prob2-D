package servicos;

import enums.TipoOperacao;
import interfaces.IServico;

public class ServicoAnaliseInvestimento implements IServico {
	
	@Override
	public void executarServico(String infoCliente, TipoOperacao tipo) {
		System.out.print(infoCliente);
		System.out.println("Fazendo analise de investimento");		
	}
	
	@Override
	public boolean podeExecutar(TipoOperacao tipo) {
		return tipo == TipoOperacao.ENTRADA;
	}

}
