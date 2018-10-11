package factories;

import enums.TipoNotificacao;
import interfaces.INotificacao;
import notificacoes.NotificacaoJMS;
import notificacoes.NotificacaoSMS;
import notificacoes.NotificacaoWhatsApp;

public class FactoryNotificacoes {
	
	public static INotificacao criaNotificacaoPF(TipoNotificacao tipo) {
    	switch (tipo) {
	    	case WhatsApp: return new NotificacaoWhatsApp();
	    	case SMS:      return new NotificacaoSMS();
	    	case JMS:      break;
    	}
    	
    	return null;
    }
	
	public static INotificacao criaNotificacaoPJ(TipoNotificacao tipo) {
    	switch (tipo) {
	    	case WhatsApp: return new NotificacaoWhatsApp();
	    	case SMS:      return new NotificacaoSMS();
	    	case JMS:      return new NotificacaoJMS();
    	}
    	
    	return null;
    }
}
