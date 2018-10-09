package problema2;

public class NotificadorMensagemPessoaJuridica extends NotificadorMensagem {
	
	public void addNotificacao(NotificacaoJMS notificacao) {
		notificacoes.add(notificacao);
	}
}
