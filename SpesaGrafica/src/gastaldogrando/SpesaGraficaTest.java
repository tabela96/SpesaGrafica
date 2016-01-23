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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnNuovoScontrino = new Button(shell, SWT.NONE);
		btnNuovoScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				scontrino_text.setText("");
			}
		});
		btnNuovoScontrino.setBounds(259, 21, 101, 25);
		btnNuovoScontrino.setText("Nuovo scontrino");
		
		Label lblTesseraFedelt = new Label(shell, SWT.NONE);
		lblTesseraFedelt.setBounds(23, 31, 81, 15);
		lblTesseraFedelt.setText("Tessera fedelt\u00E0:");
		
		Button btnSi = new Button(shell, SWT.CHECK);
		btnSi.setBounds(116, 30, 36, 16);
		btnSi.setText("Si");
		
		Button btnNo = new Button(shell, SWT.CHECK);
		btnNo.setBounds(158, 30, 36, 16);
		btnNo.setText("No");
		
		scontrino_text = new Text(shell, SWT.BORDER);
		scontrino_text.setBounds(259, 66, 128, 114);

	}
}
