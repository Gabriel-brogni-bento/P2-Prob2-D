package servicos;

import enums.TipoOperacao;
import interfaces.IServico;

public class ServicoOfertaFinanciamento implements IServico {

	@Override
	public void executarServico(String infoCliente, TipoOperacao tipo) {
		System.out.print(infoCliente);
		System.out.println("Fazendo oferta financiamento");
	}

	@Override
	public boolean podeExecutar(TipoOperacao tipo) {
		return tipo == TipoOperacao.SAIDA;
	}

}
