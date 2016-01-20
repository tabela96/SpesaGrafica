package gastaldogrando;


public class ListaSpesaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaSpesa ls=new ListaSpesa(true);
		Alimentari a1=new Alimentari("123", "Pepe", 10, new Data(10, 10, 2016));
		Alimentari a2=new Alimentari("123", "Pane", 5, new Data(12, 05, 2016));
		NonAlimentari na1=new NonAlimentari("123", "Libro", 25, "Carta");
		NonAlimentari na2=new NonAlimentari("123", "Bicchieri", 15, "Vetro");
		//PRIMO PRODOTTO - ALIMENTARE
		try {
			ls.aggiungiProdotto(a1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prodotto: "+a1.descrizione+" aggiunto allo scontrino");
		
		//SECONDO PRODOTTO - ALIMENTARE
		try {
			ls.aggiungiProdotto(a2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prodotto: "+a2.descrizione+" aggiunto allo scontrino");
		
		//TERZO PRODOTTO - NON ALIMENTARE
		try {
			ls.aggiungiProdotto(na1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prodotto: "+na1.descrizione+" aggiunto allo scontrino");
		
		//QUARTO PRODOTTO - NON ALIMENTARE
		try {
			ls.aggiungiProdotto(na2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prodotto: "+na2.descrizione+" aggiunto allo scontrino");
		
		ls.calcTotale();
		System.out.println("Il totale della spesa è: "+ls.calcTotale());
		
	}

}
