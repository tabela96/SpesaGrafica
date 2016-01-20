package gastaldogrando;



public class ListaSpesa {
	Prodotto lista[];
	boolean tessera;
	private int numProdotti;
	private int MAX_PRODOTTI;
	
	public ListaSpesa(boolean tessera){
		this.numProdotti=0;
		this.MAX_PRODOTTI=100;
		this.lista=new Prodotto[MAX_PRODOTTI];
		this.tessera=tessera;
		
	}
	
	public void aggiungiProdotto(Prodotto p) throws Exception{
		if(numProdotti<MAX_PRODOTTI){
			if(tessera){
				p.applicaSconto();
			}
			lista[numProdotti++]=p;
		}else{
			throw Exception("La lista è piena");
		}
	}


	private Exception Exception(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double calcTotale(){
		double totale=0;
		for(int i=0;i<numProdotti;i++){
			totale=totale+lista[i].getPrezzo();
		}
		return totale;
	}
	
	
}	
