package problema2;

public class NotificadorPessoaJuridica extends Notificador {
	
	public void addNotificacao(NotificacaoJMS notificacao) {
		notificacoes.add(notificacao);
	}
}
