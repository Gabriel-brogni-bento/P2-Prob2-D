package problema2;



/**
 *
 * @author marcel
 */
public class ClientePessoaFisica extends Cliente{
    private String cpf;

    public ClientePessoaFisica(String nome, String telCelular, String telFixo, String cpf) {
        super(nome, telCelular, telFixo);
        this.setCpf(cpf);
        this.notificador = new Notificador();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setTipoNotificacao(TipoNotificacao tipo) {
    	switch (tipo) {
		case WhatsApp:
			notificador.addNotificacao(new NotificacaoWhatsApp());
			break;
		case SMS: 
			notificador.addNotificacao(new NotificacaoSMS());
			break;
		}
    }
}
