package problema2;

import java.util.List;

public class BaixaAutomaticaInvestimento implements IServico {
	private List<Operacao> operacoes;

	@Override
	public void executarServico() {
		for (int i = 0; i < operacoes.size(); ++i) {
			System.out.println(operacoes.get(i).toString());
		}
		
		operacoes.clear();
	}
	
	public void setListaOperacoes(List<Operacao> op) {
		operacoes = op;
	}
}
