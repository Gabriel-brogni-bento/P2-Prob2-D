package problema2;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<Operacao> operacoes = new ArrayList();

    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this);
          
        operacoes.add(oper);
        this.saldo -= valor;
       
        cliente.servicos.setMensagem("Saque de " + valor + " reais efetuado");
        cliente.servicos.setListaOperacoesBaixaAutomatica(operacoes);
        cliente.servicos.setListaOperacoesAnaliseFluxo(operacoes);
        executarServicos();
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        operacoes.add(oper);
        this.saldo += valor;
        
        cliente.servicos.setMensagem("Dep�sito de " + valor + " reais efetuado");
        cliente.servicos.setListaOperacoesBaixaAutomatica(operacoes);
        cliente.servicos.setListaOperacoesAnaliseFluxo(operacoes);
        executarServicos();
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        operacoes.add(oper);
        this.saldo -= valor;
        
        cliente.servicos.setMensagem("Transferencia de " + valor + "  reais para " + destino.cliente.getNome());
        cliente.servicos.setListaOperacoesBaixaAutomatica(operacoes);
        cliente.servicos.setListaOperacoesAnaliseFluxo(operacoes);
        executarServicos();
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        operacoes.add(oper);
        this.saldo += valor;   
        
        cliente.servicos.setMensagem("Transferencia de " + valor + " reais de " + origem.cliente.getNome());
        cliente.servicos.setListaOperacoesBaixaAutomatica(operacoes);
        cliente.servicos.setListaOperacoesAnaliseFluxo(operacoes);
        executarServicos();
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
    
    private void executarServicos() {
    	cliente.servicos.executarServicos();    	
    }
}
