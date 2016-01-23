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
		scontrino_text.setBounds(10, 142, 459, 388);
		
		Label lblProdotto = new Label(shell, SWT.NONE);
		lblProdotto.setBounds(10, 10, 55, 15);
		lblProdotto.setText("Prodotto");
		
		Label lblDescrizione = new Label(shell, SWT.NONE);
		lblDescrizione.setBounds(10, 41, 60, 15);
		lblDescrizione.setText("Descrizione");
		
		Label lblCodice = new Label(shell, SWT.NONE);
		lblCodice.setBounds(10, 76, 55, 15);
		lblCodice.setText("Codice");
		
		Label lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(10, 108, 55, 15);
		lblPrezzo.setText("Prezzo");
		
		prodotto_text = new Text(shell, SWT.BORDER);
		prodotto_text.setBounds(80, 12, 76, 21);
		
		descrizione_text = new Text(shell, SWT.BORDER);
		descrizione_text.setBounds(80, 38, 76, 21);
		
		codice_text = new Text(shell, SWT.BORDER);
		codice_text.setBounds(80, 70, 76, 21);
		
		prezzo_text = new Text(shell, SWT.BORDER);
		prezzo_text.setText("");
		prezzo_text.setBounds(80, 108, 76, 21);

	}
}
