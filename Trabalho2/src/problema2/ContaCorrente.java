package problema2;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.*;
import factories.FactoryServicos;
import interfaces.INotificacao;
import interfaces.IServico;
import servicos.ServicoNotificadorMensagem;


/*
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 */

/**
 *
 * @author marcel
 */
public class ContaCorrente {
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private List<Operacao> operacoes = new ArrayList<Operacao>();
    protected GerenciadorServicos servicos;

    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);

        this.servicos = new GerenciadorServicos(this);
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(), TipoOperacao.SAIDA,new Date(),this);
          
        operacoes.add(oper);
        this.saldo -= valor;
       
        servicos.setMensagem("Saque de " + valor + " reais efetuado");
        executarServicos(TipoOperacao.SAIDA);
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        operacoes.add(oper);
        this.saldo += valor;
        
        servicos.setMensagem("Dep�sito de " + valor + " reais efetuado");
        executarServicos(TipoOperacao.ENTRADA);
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new Servico(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        operacoes.add(oper);
        this.saldo -= valor;
        
        servicos.setMensagem("Transferencia de " + valor + "  reais para " + destino.cliente.getNome());
        executarServicos(TipoOperacao.SAIDA);
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new Servico(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        operacoes.add(oper);
        this.saldo += valor;   
        
        servicos.setMensagem("Transferencia de " + valor + " reais de " + origem.cliente.getNome());
        executarServicos(TipoOperacao.ENTRADA);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String toString(){
        return this.getChave();
    }
    
    private void executarServicos(TipoOperacao tipo) {
    	servicos.executarServicos(tipo);    	
    }
    
    public void addNotificacao(TipoNotificacao tipo) {
    	
    	ServicoNotificadorMensagem notificador = (ServicoNotificadorMensagem) servicos.getServico(TipoServico.Notificacao);
    			
		if (notificador != null) {
			
			INotificacao objNotificacao = cliente.getObjNotificacao(tipo);
		
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
