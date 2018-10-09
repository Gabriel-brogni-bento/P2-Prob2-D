package problema2;

public class NotificacaoJMS implements INotificacao {

	@Override
	public void enviarNotificacao(String mensagem) {
		System.out.println("Mensagem por JMS: " + mensagem);
	}

}
