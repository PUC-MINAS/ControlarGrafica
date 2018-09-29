import java.util.List;
import java.util.Set;

public class Gerente {
	
	List<Pedido> pedidos;
	
	public Gerente (List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void ListarServicos() {
		for(Object o : pedidos) {
			System.out.println(o);
		}
	}
	
	public Pedido getPedidoMaiorPrioridade () {
		if(this.pedidos.isEmpty()) {
			return null;
		}
		else {
			Pedido prioritario = pedidos.get(0);
			int iMaior = 0;
			
			for (int i = 0; i < pedidos.size(); i++) {
				Pedido p = pedidos.get(i);
				if (prioritario.getPrioridade() > p.getPrioridade()) {
					prioritario = p;
					iMaior = i;
				}
			}
			
			
			
			return pedidos.remove(iMaior);
		}
		
	}
	
	public Pedido getPedidoMenorTrabalho() {
		if(this.pedidos.isEmpty()) {
			return null;
		}
		else {
			Pedido shortest = pedidos.get(0);
			int iMenor = 0;
			
			for (int i = 0; i < pedidos.size(); i++) {
				Pedido p = pedidos.get(i);
				if (shortest.getFolhas() > p.getFolhas()) {
					shortest = p;
					iMenor = i;
				}
			}			
			
			return pedidos.remove(iMenor);
		}
	}
	
	public boolean temPedido () {
		return this.pedidos.isEmpty() == false;
	}

	
	/*public static void dividirServico(int regra, int distribuicao) {
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
	}*/
	
	

}
