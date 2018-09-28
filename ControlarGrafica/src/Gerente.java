import java.util.Scanner;
import java.util.Set;

public class Gerente {
	
	public static void dividirServico(int regra, int distribuicao) {
		Set<Pedido> servico = organizar(regra);
		switch(distribuicao) {
			case 1:
				metade(servico);
				break;
			case 2:
				prioridade(servico);
				break;
			case 3:
			
		}
	}
	
	private static void prioridade(Set<Pedido> servico) {
		for(int i = 0; i <= servico.size()/2;i++) {
			
		}	
	}

	private static void metade(Set<Pedido> servico) {
		// TODO Auto-generated method stub
		
	}

	public static Set<Pedido> organizar(int regra) {
		switch(regra) {
			case 1:
				return Regras.fifo();
			case 2:
				return Regras.prioridade();
		}
		return null;
	}
	
	

}
