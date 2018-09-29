import java.util.List;
import java.util.Scanner;

public class Aplicacao {

	public static final Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) {
		
		Leitor a = new Leitor();
		Gerente gerente = new Gerente(a.ler("dadosGrafica.txt"));
		
		System.out.println(gerente.getPedidoMaiorPrioridade());
		System.out.println(gerente.getPedidoMenorTrabalho());
		
		
//		Regras.fifo().forEach(p->{
//			int numPg = p.getNumPag(),tempo=1;
//			for(int i = 80;i < numPg;i+=80) {
//				tempo++;
//				numPg-=80;
//			}
//			p.setTempoGasto(tempo);
//			Regras.tempo += tempo;
//		});
//			
//		Regras.prioridade().forEach(p->{
//			int numPg = p.getNumPag(),tempo=1;
//			for(int i = 80;i < numPg;i+=80) {
//				tempo++;
//				numPg-=80;
//			}
//			p.setTempoGasto(tempo);
//			Regras.tempo += tempo;
//		});
 	}
}