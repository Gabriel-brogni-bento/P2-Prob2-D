package problema2;

import enums.TipoNotificacao;
import factories.FactoryNotificacoes;
import interfaces.INotificacao;

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
    
	@Override
	public INotificacao getObjNotificacao(TipoNotificacao tipo) {
		return FactoryNotificacoes.criaNotificacaoPJ(tipo);
	}
}
