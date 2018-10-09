package problema2;


/**
 *
 * @author marcel
 */
public class ClientePessoaJuridica extends Cliente{
    private String cnpj;
    private String servidorJMS;

    public ClientePessoaJuridica(String nome, String telCelular, String telFixo, String cnpj, String servidorJMS) {
        super(nome, telCelular, telFixo);
        this.setCnpj(cnpj);
        this.setServidorJMS(servidorJMS);
    } 
    
    @Override
    public void setTipoNotificacao(TipoNotificacao tipo) {
    	
    	NotificadorMensagemPessoaJuridica notificador = (NotificadorMensagemPessoaJuridica) servicos.getServico(TipoServico.Notificacao);
		
		if (notificador == null)
			return;
		
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
    
    public void setTipoServico(TipoServico tipo) {
    	switch (tipo) {
    	case Notificacao:
    		servicos.adicionarServico(new NotificadorMensagemPessoaJuridica());
    		break;
    	case AnaliseFluxoCaixa:
    		servicos.adicionarServico(new AnaliseFluxoCaixa());
    		break;
    	case BaixaAutomatica:
    		servicos.adicionarServico(new BaixaAutomaticaInvestimento());
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
