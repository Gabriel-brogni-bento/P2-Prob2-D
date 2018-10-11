package problema2;

/*
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 */

import java.util.HashMap;

import enums.TipoNotificacao;
import enums.TipoServico;
import factories.FactoryServicos;
import interfaces.INotificacao;
import interfaces.IServico;
import servicos.ServicoNotificadorMensagem;


/**
 *
 * @author marcel
 */
public abstract class Cliente {
    private String nome;
    private String telCelular;
    private String telFixo;
    private HashMap<String,ContaCorrente> contas;
    protected GerenciadorServicos servicos;

    public Cliente(String nome, String telCelular, String telFixo) {
        this.setNome(nome);
        this.setTelCelular(telCelular);
        this.setTelFixo(telFixo);
        this.contas = new HashMap<String,ContaCorrente>();
        this.servicos = new GerenciadorServicos(this);
    }

    public void addConta(ContaCorrente cc){
        String chave = cc.getChave();
        if (this.contas.containsKey(chave)){
            throw new IllegalArgumentException("Já existe conta corrente com este número/agência");
        }
        else {
            this.contas.put(chave,cc);
            cc.setCliente(this);
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }
   
    public abstract INotificacao getObjNotificacao(TipoNotificacao tipo);
    
    public void addNotificacao(TipoNotificacao tipo) {
    	
    	ServicoNotificadorMensagem notificador = (ServicoNotificadorMensagem) servicos.getServico(TipoServico.Notificacao);
    			
		if (notificador != null) {
			
			INotificacao objNotificacao = getObjNotificacao(tipo);
		
			if (objNotificacao != null) {
				notificador.addNotificacao(tipo, objNotificacao);
			}
		}
    }
    
    public void removeNotificacao(TipoNotificacao tipo) {
    	ServicoNotificadorMensagem notificador = (ServicoNotificadorMensagem) servicos.getServico(TipoServico.Notificacao);
    	
    	if (notificador != null) {
    		notificador.removeNotificacao(tipo);
    	}
    }
    
    public void addServico(TipoServico tipo) {
    	IServico objServico = FactoryServicos.criaServico(tipo); 
		
		if (objServico != null)
			servicos.addServico(tipo, objServico);
    }
    
    public void removeServico(TipoServico tipo) {
    	servicos.removeServico(tipo);
    }
}
