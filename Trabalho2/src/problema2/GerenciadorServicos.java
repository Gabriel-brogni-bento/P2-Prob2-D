package problema2;

import java.util.HashMap;
import java.util.Map;

import enums.TipoOperacao;
import enums.TipoServico;
import interfaces.IServico;
import servicos.ServicoNotificadorMensagem;


public class GerenciadorServicos {
	private HashMap<TipoServico, IServico> servicos = new HashMap<TipoServico, IServico>();
	private Cliente cliente;
	
	public GerenciadorServicos(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void executarServicos(ContaCorrente conta, TipoOperacao tipo) {
		
		for (Map.Entry<TipoServico, IServico> servicoAtual : servicos.entrySet()) {
			
			if (servicoAtual.getValue().podeExecutar(tipo)) {
				String infoCliente = ("Cliente " +  cliente.getNome() + " conta " + conta.getNumero() + "-" + conta.getAgencia() + " - ");
				servicoAtual.getValue().executarServico(infoCliente, tipo);
			}	
		}
	}
	
	public IServico getServico(TipoServico tipo) {
		return servicos.get(tipo);
	}
	
	public void addServico(TipoServico tipo, IServico servico) {
		servicos.put(tipo, servico);
	}
	
	public void removeServico(TipoServico tipo) {
		servicos.remove(tipo);
	}
	
	public void setMensagem(String msg) {
		ServicoNotificadorMensagem notificador = (ServicoNotificadorMensagem) getServico(TipoServico.Notificacao);
		
		if (notificador != null)
			notificador.setMensagem(msg);
	}
}
