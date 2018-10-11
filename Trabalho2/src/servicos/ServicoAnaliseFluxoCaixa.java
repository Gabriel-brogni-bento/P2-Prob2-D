package servicos;

import enums.TipoOperacao;
import interfaces.IServico;

public class ServicoAnaliseFluxoCaixa implements IServico {
	
	@Override
	public void executarServico(String infoCliente, TipoOperacao tipo) {
		System.out.print(infoCliente);
		System.out.println("fazendo analise fluxo caixa");
	}
	
	@Override
	public boolean podeExecutar(TipoOperacao tipo) {
		return true;
	}
}
