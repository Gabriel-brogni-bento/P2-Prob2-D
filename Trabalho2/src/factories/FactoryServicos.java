package factories;

import enums.TipoServico;
import interfaces.IServico;
import servicos.ServicoAnaliseFluxoCaixa;
import servicos.ServicoAnaliseInvestimento;
import servicos.ServicoBaixaAutomaticaInvestimento;
import servicos.ServicoNotificadorMensagem;
import servicos.ServicoOfertaFinanciamento;

public class FactoryServicos {
	
    public static IServico criaServico(TipoServico tipo) {
    	switch (tipo) {
	    	case Notificacao:         return new ServicoNotificadorMensagem();
	    	case AnaliseFluxoCaixa:   return new ServicoAnaliseFluxoCaixa();
	    	case BaixaAutomatica:     return new ServicoBaixaAutomaticaInvestimento();
	    	case AnaliseInvestimento: return new ServicoAnaliseInvestimento();
	    	case OfertaFinanciamento: return new ServicoOfertaFinanciamento();
    	}
    	
    	return null;
    }
}
