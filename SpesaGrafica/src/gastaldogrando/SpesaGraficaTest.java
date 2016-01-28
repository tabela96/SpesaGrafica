package gastaldogrando;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.dialogs.ShowViewDialog;

import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Popup;

import org.eclipse.swt.widgets.List;

public class SpesaGraficaTest {

	protected Shell shlListaSpesaGrafica;
	private Text prodotto_text;
	private Text descrizione_text;
	private Text codice_text;
	private Text prezzo_text;
	private Text text;
	private Text tot_text;
	private float prezzo=0;
	Prodotto[] carrello=new Prodotto[100];
	private int num=0;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SpesaGraficaTest window = new SpesaGraficaTest();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlListaSpesaGrafica.open();
		shlListaSpesaGrafica.layout();
		while (!shlListaSpesaGrafica.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlListaSpesaGrafica = new Shell();
		shlListaSpesaGrafica.setSize(495, 578);
		shlListaSpesaGrafica.setText("Lista Spesa Grafica");
		
		List scontrino = new List(shlListaSpesaGrafica, SWT.BORDER);
		scontrino.setBounds(10, 152, 459, 340);
		
		Button btnNuovoScontrino = new Button(shlListaSpesaGrafica, SWT.NONE);
		btnNuovoScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				scontrino.removeAll();
			}
		});
		btnNuovoScontrino.setBounds(368, 10, 101, 25);
		btnNuovoScontrino.setText("Nuovo scontrino");
		
		Label lblTesseraFedelt = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblTesseraFedelt.setBounds(281, 41, 81, 15);
		lblTesseraFedelt.setText("Tessera fedelt\u00E0:");
		
		Label lblProdotto = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblProdotto.setBounds(10, 10, 55, 15);
		lblProdotto.setText("Prodotto:");
		
		Label lblDescrizione = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblDescrizione.setBounds(10, 41, 60, 15);
		lblDescrizione.setText("Descrizione");
		
		Label lblCodice = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblCodice.setBounds(10, 80, 55, 15);
		lblCodice.setText("Codice");
		
		Label lblPrezzo = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblPrezzo.setBounds(10, 108, 55, 15);
		lblPrezzo.setText("Prezzo");
		
		prodotto_text = new Text(shlListaSpesaGrafica, SWT.BORDER);
		prodotto_text.setBounds(80, 12, 76, 21);
		
		descrizione_text = new Text(shlListaSpesaGrafica, SWT.BORDER);
		descrizione_text.setBounds(80, 38, 76, 21);
		
		codice_text = new Text(shlListaSpesaGrafica, SWT.BORDER);
		codice_text.setBounds(80, 80, 76, 21);
		
		prezzo_text = new Text(shlListaSpesaGrafica, SWT.BORDER);
		prezzo_text.setText("");
		prezzo_text.setBounds(80, 108, 76, 21);
		
		Button btnSi_1 = new Button(shlListaSpesaGrafica, SWT.RADIO);
		btnSi_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSi_1.setBounds(239, 10, 30, 16);
		btnSi_1.setText("SI");
		
		
		tot_text = new Text(shlListaSpesaGrafica, SWT.BORDER);
		tot_text.setBounds(96, 498, 76, 21);
		

		Button btnNo_1 = new Button(shlListaSpesaGrafica, SWT.RADIO);
		btnNo_1.setBounds(272, 10, 39, 16);
		btnNo_1.setText("NO");
		
		Button btnAggiungi = new Button(shlListaSpesaGrafica, SWT.NONE);
		btnAggiungi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int i=0;
				float prezzo=0;
				scontrino.add(prodotto_text.getText(), 0);
				scontrino.add(descrizione_text.getText(), 1);
				scontrino.add(codice_text.getText(), 2);
				scontrino.add(prezzo_text.getText(), 3);
				if(btnSi_1.isEnabled()){
					scontrino.add("ALIMENTARE: ", 0);
				}else{
					scontrino.add("NON ALIMENTARE: ", 0);
				}
				prezzo=(Float.parseFloat(prezzo_text.getText()));
				tot_text.setText(String.valueOf(prezzo));
				
			}
		});
		btnAggiungi.setBounds(174, 70, 75, 25);
		btnAggiungi.setText("Aggiungi");
		
		Button btnElimina = new Button(shlListaSpesaGrafica, SWT.NONE);
		btnElimina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnElimina.setBounds(174, 108, 75, 25);
		btnElimina.setText("Elimina");
		
		Button btnSalva = new Button(shlListaSpesaGrafica, SWT.NONE);
		btnSalva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					TextFile out;
					try {
						out = new TextFile("scontrino.txt", 'w');
						for(int i=0;i<num;i++){
							Prodotto p=carrello[i];
							if(p instanceof Alimentari){
								out.toFile("Alimentari");
								out.toFile(p.getDescrizione());
								out.toFile(p.getCodice());
							/*	out.toFile(p.getScadenza().getGiorno());
								out.toFile(p.getScadenza().getMese());
								out.toFile(p.getScadenza().getAnno());*/
							}else{
								out.toFile("Non Alimentari");
								out.toFile(p.getCodice());
								out.toFile(p.getDescrizione());
								out.toFile(String.valueOf(p.getPrezzo()));
								//out.toFile(p.getMateriale());
							}
						}
					} catch (IOException | FileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
			}
		});
		btnSalva.setBounds(296, 108, 75, 25);
		btnSalva.setText("Salva");
		
		Button btnCarica = new Button(shlListaSpesaGrafica, SWT.NONE);
		btnCarica.addSelectionListener(new SelectionAdapter() {
		});
		btnCarica.setBounds(389, 108, 75, 25);
		btnCarica.setText("Carica");
		
		Label lblAlimentare = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblAlimentare.setBounds(174, 10, 66, 15);
		lblAlimentare.setText("Alimentare:");
		
		
		Label lblPrezzoTotale = new Label(shlListaSpesaGrafica, SWT.NONE);
		lblPrezzoTotale.setBounds(10, 504, 76, 15);
		lblPrezzoTotale.setText("Prezzo totale: ");
		text = new Text(shlListaSpesaGrafica, SWT.BORDER);
		text.setBounds(96, 498, 76, 21);
		
		Button btnSi = new Button(shlListaSpesaGrafica, SWT.CHECK);
		btnSi.setBounds(376, 40, 93, 16);
		btnSi.setText("Si");
		
		Button btnNo = new Button(shlListaSpesaGrafica, SWT.CHECK);
		btnNo.setBounds(376, 63, 93, 16);
		btnNo.setText("No");
		
		
	}
}
