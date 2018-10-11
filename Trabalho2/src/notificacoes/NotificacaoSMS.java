package notificacoes;

import interfaces.INotificacao;

public class NotificacaoSMS implements INotificacao {

	@Override
	public void enviarNotificacao(String mensagem) {
		System.out.println("Mensagem por SMS: " + mensagem);
	}

}
