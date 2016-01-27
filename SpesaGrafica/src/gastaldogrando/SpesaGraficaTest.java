package gastaldogrando;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SpesaGraficaTest {

	protected Shell shell;
	private Text scontrino_text;
	private Text prodotto_text;
	private Text descrizione_text;
	private Text codice_text;
	private Text prezzo_text;
	private Text text;

	private float prezzo=0;
	private Prodotto p[];


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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(495, 578);
		shell.setText("SWT Application");
		
		Button btnNuovoScontrino = new Button(shell, SWT.NONE);
		btnNuovoScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				scontrino_text.setText("");
			}
		});
		btnNuovoScontrino.setBounds(368, 10, 101, 25);
		btnNuovoScontrino.setText("Nuovo scontrino");
		
		Label lblTesseraFedelt = new Label(shell, SWT.NONE);
		lblTesseraFedelt.setBounds(296, 41, 81, 15);
		lblTesseraFedelt.setText("Tessera fedelt\u00E0:");
		
		scontrino_text = new Text(shell, SWT.BORDER);
		scontrino_text.setBounds(10, 142, 459, 342);
		
		Label lblProdotto = new Label(shell, SWT.NONE);
		lblProdotto.setBounds(10, 10, 55, 15);
		lblProdotto.setText("Prodotto:");
		
		Label lblDescrizione = new Label(shell, SWT.NONE);
		lblDescrizione.setBounds(10, 41, 60, 15);
		lblDescrizione.setText("Descrizione");
		
		Label lblCodice = new Label(shell, SWT.NONE);
		lblCodice.setBounds(10, 80, 55, 15);
		lblCodice.setText("Codice");
		
		Label lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(10, 108, 55, 15);
		lblPrezzo.setText("Prezzo");
		
		prodotto_text = new Text(shell, SWT.BORDER);
		prodotto_text.setBounds(80, 12, 76, 21);
		
		descrizione_text = new Text(shell, SWT.BORDER);
		descrizione_text.setBounds(80, 38, 76, 21);
		
		codice_text = new Text(shell, SWT.BORDER);
		codice_text.setBounds(80, 80, 76, 21);
		
		prezzo_text = new Text(shell, SWT.BORDER);
		prezzo_text.setText("");
		prezzo_text.setBounds(80, 108, 76, 21);
		
		Button btnSi_1 = new Button(shell, SWT.RADIO);
		btnSi_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSi_1.setBounds(239, 10, 90, 16);
		btnSi_1.setText("SI");
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(272, 10, 90, 16);
		btnRadioButton.setText("NO");
		
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(96, 498, 76, 21);
		
		Button btnAggiungi = new Button(shell, SWT.NONE);
		btnAggiungi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				scontrino_text.setText(scontrino_text.getText() + prodotto_text.getText());
				scontrino_text.setText(scontrino_text.getText() + "\n");
				scontrino_text.setText(scontrino_text.getText() + descrizione_text.getText());
				scontrino_text.setText(scontrino_text.getText() + "\n");
				scontrino_text.setText(scontrino_text.getText() + codice_text.getText());
				scontrino_text.setText(scontrino_text.getText() + "\n");
				scontrino_text.setText(scontrino_text.getText() + prezzo_text.getText());
				scontrino_text.setText(scontrino_text.getText() + "\n");				
				scontrino_text.setText(scontrino_text.getText() + prodotto_text.getText()+ "\n");
				scontrino_text.setText(scontrino_text.getText() + "\n");
				scontrino_text.setText(scontrino_text.getText() + descrizione_text.getText()+ "\n");
				scontrino_text.setText(scontrino_text.getText() + "\n");
				scontrino_text.setText(scontrino_text.getText() + codice_text.getText()+ "\n");
				scontrino_text.setText(scontrino_text.getText() + "\n");
				scontrino_text.setText(scontrino_text.getText() + prezzo_text.getText()+ "\n");
				scontrino_text.setText(scontrino_text.getText() + "\n");
				if(btnSi_1.isEnabled()){
					scontrino_text.setText(scontrino_text.getText() + "ALIMENTARE\n");
				}
				if(btnRadioButton.isEnabled()){
					scontrino_text.setText(scontrino_text.getText() + "NON ALIMENTARE\n");
				}
				prezzo=prezzo+Float.parseFloat(prezzo_text.getText());
				text.setText(String.valueOf(prezzo));
			}
		});
		btnAggiungi.setBounds(174, 70, 75, 25);
		btnAggiungi.setText("Aggiungi");
		
		Button btnElimina = new Button(shell, SWT.NONE);
		btnElimina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnElimina.setBounds(174, 108, 75, 25);
		btnElimina.setText("Elimina");
		
		Button btnSalva = new Button(shell, SWT.NONE);
		btnSalva.setBounds(296, 108, 75, 25);
		btnSalva.setText("Salva");
		
		Button btnCarica = new Button(shell, SWT.NONE);
		btnCarica.setBounds(389, 108, 75, 25);
		btnCarica.setText("Carica");
		
		Label lblAlimentare = new Label(shell, SWT.NONE);
		lblAlimentare.setBounds(174, 10, 66, 15);
		lblAlimentare.setText("Alimentare:");
		
		
		Label lblPrezzoTotale = new Label(shell, SWT.NONE);
		lblPrezzoTotale.setBounds(10, 504, 76, 15);
		lblPrezzoTotale.setText("Prezzo totale: ");
		text = new Text(shell, SWT.BORDER);
		text.setBounds(96, 498, 76, 21);
	}
}
