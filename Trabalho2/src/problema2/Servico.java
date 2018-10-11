package problema2;


import problema2.ContaCorrente;
import java.util.Date;

import enums.TipoOperacao;

/**
 *
 * @author marcel
 */
public class Servico extends Operacao{
    private ContaCorrente contraPartida;

    public Servico(double valor, double saldoAnterior, TipoOperacao tipo, Date dataHora, ContaCorrente conta, ContaCorrente contraPartida) {
        super(valor, saldoAnterior, tipo, dataHora, conta);
        this.contraPartida = contraPartida;
    }

    public ContaCorrente getContraPartida() {
        return contraPartida;
    }
 
    @Override
    public String toString(){
        return "Conta "+this.getConta().getChave()+": Operação de Transferência: "+this.getTipo()
                +" no valor de "+this.getValor()+" em "+df.format(this.getDataHora())
                +" com a conta "+this.contraPartida.getChave();
    }    
}
