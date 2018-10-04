package problema2;

import java.util.ArrayList;

public class Notificador {
	protected ArrayList<INotificacao> notificacoes; 
	
	public void enviarNotificacoes(String mensagem) {
		for (int i = 0; i < notificacoes.size(); ++i) {
			notificacoes.get(i).enviarNotificacao(mensagem);
		}
	}
	
	public void addNotificacao(NotificacaoWhatsApp notificacao) {
		notificacoes.add(notificacao);
	}
	
	public void addNotificacao(NotificacaoSMS notificacao) {
		notificacoes.add(notificacao);
	}
	
	

}
