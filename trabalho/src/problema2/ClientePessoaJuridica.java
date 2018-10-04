package problema2;


/**
 *
 * @author marcel
 */
public class ClientePessoaJuridica extends Cliente{
    private String cnpj;
    private String servidorJMS;
    private NotificadorPessoaJuridica notificador;

    public ClientePessoaJuridica(String nome, String telCelular, String telFixo, String cnpj, String servidorJMS) {
        super(nome, telCelular, telFixo);
        this.setCnpj(cnpj);
        this.setServidorJMS(servidorJMS);
        this.notificador = new NotificadorPessoaJuridica();
    } 
    
    public void setTipoNotificacao(TipoNotificacao tipo) {
    	switch (tipo) {
		case WhatsApp:
			notificador.addNotificacao(new NotificacaoWhatsApp());
			break;
		case SMS: 
			notificador.addNotificacao(new NotificacaoSMS());
			break;
		case JMS:
			notificador.addNotificacao(new NotificacaoJMS());
			break;
		}
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getServidorJMS() {
        return servidorJMS;
    }

    public void setServidorJMS(String servidorJMS) {
        this.servidorJMS = servidorJMS;
    }
    
}
