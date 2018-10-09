package problema2;

import java.util.ArrayList;

public class NotificadorMensagem implements IServico {
	protected ArrayList<INotificacao> notificacoes; 
	private String mensagem;
	
	public NotificadorMensagem() {
		notificacoes = new ArrayList<INotificacao>();
	}
	
	public void addNotificacao(NotificacaoWhatsApp notificacao) {
		notificacoes.add(notificacao);
	}
	
	public void addNotificacao(NotificacaoSMS notificacao) {
		notificacoes.add(notificacao);
	}

	@Override
	public void executarServico() {
		if (mensagem.isEmpty())
			return;
		
		for (int i = 0; i < notificacoes.size(); ++i) {
			notificacoes.get(i).enviarNotificacao(mensagem);
		}
		
		mensagem = "";
	}
	
	public void setMensagem(String msg) {
		mensagem = msg;
	}


	
	

}
