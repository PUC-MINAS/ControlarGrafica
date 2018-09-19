import java.io.IOException;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Arquivo a = new Arquivo();
		List<Pedido> lista = a.ler("dadosGrafica.txt");
		
		for(Pedido p : lista){
			System.out.println(p);
		}
	}

}
