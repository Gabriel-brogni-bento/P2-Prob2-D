package problema2;

import enums.TipoNotificacao;
import factories.FactoryNotificacoes;
import interfaces.INotificacao;

/**
 *
 * @author marcel
 */
public class ClientePessoaFisica extends Cliente {
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
	public INotificacao getObjNotificacao(TipoNotificacao tipo) {
		return FactoryNotificacoes.criaNotificacaoPF(tipo);
	}
}
