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
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public void setTipoNotificacao(TipoNotificacao tipo) {
    	
    	NotificadorMensagem notificador = (NotificadorMensagem) servicos.getServico(TipoServico.Notificacao);
    			
		if (notificador == null)
			return;
    	
    	switch (tipo) {
		case WhatsApp:
			notificador.addNotificacao(new NotificacaoWhatsApp());
			break;
		case SMS: 
			notificador.addNotificacao(new NotificacaoSMS());
			break;
		}
    }
    
    public void setTipoServico(TipoServico tipo) {
    	switch (tipo) {
    	case Notificacao:
    		servicos.adicionarServico(new NotificadorMensagem());
    		break;
    	case AnaliseFluxoCaixa:
    		servicos.adicionarServico(new AnaliseFluxoCaixa());
    		break;
    	case BaixaAutomatica:
    		servicos.adicionarServico(new BaixaAutomaticaInvestimento());
    		break;
    	}
    }

}
