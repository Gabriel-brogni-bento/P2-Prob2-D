package problema2;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorServicos {
	protected ArrayList<IServico> servicos;
	
	public GerenciadorServicos() {
		servicos = new ArrayList<IServico>();
	}
	
	public void executarServicos() {
		for (int i = 0; i < servicos.size(); ++i) {
			servicos.get(i).executarServico();
		}
	}
	
	public IServico getServico(TipoServico tipo) {
		for (int i = 0; i < servicos.size(); ++i) {
			IServico servicoAtual = servicos.get(i);
						
			switch(tipo) {
				case Notificacao:
					if (servicoAtual instanceof NotificadorMensagem)
						return servicoAtual;
					break;
				case BaixaAutomatica:
					if (servicoAtual instanceof BaixaAutomaticaInvestimento)
						return servicoAtual;
					break;
				case AnaliseFluxoCaixa:
					if (servicoAtual instanceof AnaliseFluxoCaixa)
						return servicoAtual;
					break;
			}
		}
		
		return null;
	}
	
	public void adicionarServico(IServico servico) {
		servicos.add(servico);
	}
	
	public void setMensagem(String msg) {
		NotificadorMensagem notificador = (NotificadorMensagem) getServico(TipoServico.Notificacao);
		
		if (notificador != null)
			notificador.setMensagem(msg);
	}
	
	public void setListaOperacoesAnaliseFluxo(List<Operacao> op) {
		AnaliseFluxoCaixa notificador = (AnaliseFluxoCaixa) getServico(TipoServico.AnaliseFluxoCaixa);
		
		if (notificador != null)
			notificador.setListaOperacoes(op);
	}
	
	public void setListaOperacoesBaixaAutomatica(List<Operacao> op) {
		BaixaAutomaticaInvestimento notificador = (BaixaAutomaticaInvestimento) getServico(TipoServico.BaixaAutomatica);
		
		if (notificador != null)
			notificador.setListaOperacoes(op);
	}
}
