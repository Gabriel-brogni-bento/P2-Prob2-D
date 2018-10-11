package servicos;

import java.util.HashMap;
import java.util.Map;

import enums.TipoNotificacao;
import enums.TipoOperacao;
import interfaces.INotificacao;
import interfaces.IServico;

public class ServicoNotificadorMensagem implements IServico { 
	private HashMap<TipoNotificacao, INotificacao> notificacoes = new HashMap<TipoNotificacao, INotificacao>();
	private String mensagem;
	
	public void setMensagem(String msg) {
		mensagem = msg;
	}
	
	public void addNotificacao(TipoNotificacao tipo, INotificacao notificacao) {
		notificacoes.put(tipo, notificacao);
	}
	
	public void removeNotificacao(TipoNotificacao tipo) {
		notificacoes.remove(tipo);
	}
	
	@Override
	public void executarServico(String infoCliente, TipoOperacao tipo) {
		
		if (mensagem.isEmpty())
			return;
		
		for (Map.Entry<TipoNotificacao, INotificacao> notificacaoAtual : notificacoes.entrySet()) {
			System.out.print(infoCliente);			
			notificacaoAtual.getValue().enviarNotificacao(mensagem);
		}

		mensagem = "";
	}

	@Override
	public boolean podeExecutar(TipoOperacao tipo) {
		return true;
	}
}
