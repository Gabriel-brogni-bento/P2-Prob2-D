package interfaces;

import enums.TipoOperacao;

public interface IServico {
	public void executarServico(String infoCliente, TipoOperacao tipo);
	public boolean podeExecutar(TipoOperacao tipo);
}
