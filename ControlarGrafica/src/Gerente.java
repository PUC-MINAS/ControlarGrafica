import java.util.List;
import java.util.Set;

public class Gerente {
	
	private List<Pedido> pedidos;
	
	public Gerente (List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void ListarServicos() {
		for(Object o : pedidos) {
			System.out.println(o);
		}
	}
	
	public int TempoTrabalhoTotal() {
		int tempo = 0;
		for(Pedido e : pedidos) {
			tempo += e.tempoServico() + 15;
		}
		
		return tempo;
	}
	
	public int TempoTrabalhoTotalEmHoras() {
		return TempoTrabalhoTotal() / 60 / 60;
	}
	
	public synchronized Pedido getPedidoMaiorPrioridade () {
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
			
			//this.recalcularPrioridade();
			
			return pedidos.remove(iMaior);
		}
		
	}
	
	public synchronized Pedido getPedidoMenorTrabalho() {
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
			
			//this.recalcularPrioridade();
			
			return pedidos.remove(iMenor);
		}
	}
	
	public boolean temPedido () {
		return this.pedidos.isEmpty() == false;
	}
	
	public void recalcularPrioridade() {
		for(Pedido p : this.pedidos) {
			p.calcularPrioridade();
		}
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
