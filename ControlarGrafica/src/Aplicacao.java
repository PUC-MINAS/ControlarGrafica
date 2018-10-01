import java.util.Scanner;

public class Aplicacao {

	public static final Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) throws InterruptedException {
		
		Leitor a = new Leitor();
		Gerente gerente = new Gerente(a.ler("dadosGrafica.txt"));
		
		Impressora A = new Impressora(gerente, 1, "Impressora A");
		Impressora B = new Impressora(gerente, 2, "Impressora B");
		
		A.start();
		B.start();
		
		A.join();  B.join(); 
		System.out.println();
		System.out.println(A.getName() + " Tempo trabalho de trabalho: " + A.tempoTrabalhoEmHoras() + " - Atrasos: " + A.getAtrasos() );
		System.out.println(B.getName() + " Tempo trabalho de trabalho: " + B.tempoTrabalhoEmHoras() + " - Atrasos: " + B.getAtrasos() );
		
		
		
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