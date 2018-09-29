import java.util.Set;
import java.util.TreeSet;

public class Regras {
	
	public static final int pgPorMin = 80;
	
	public static int tempo=0;

	public static Set<Pedido> fifo() {
		
		return Leitor.ler("dadosGrafica.txt");

	}
	
	public static TreeSet<Pedido> prioridade(){
						
		TreeSet<Pedido> fila = new TreeSet<Pedido>();
				
		Leitor.ler("dadosGrafica.txt").forEach(p -> {
			
			p.setPrioridade(p.getNumPag()/80);
			
			fila.add(p);
			
		});
				
		return fila;
	}
}
