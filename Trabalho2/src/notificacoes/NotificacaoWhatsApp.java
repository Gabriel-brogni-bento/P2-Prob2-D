package notificacoes;

import interfaces.INotificacao;

public class NotificacaoWhatsApp implements INotificacao {

	@Override
	public void enviarNotificacao(String mensagem) {
		System.out.println("Mensagem por WhatsApp: " + mensagem);
	}
}
