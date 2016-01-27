package gastaldogrando;

public class FileException extends Exception {
	private String matter="";
	
	public FileException(String matter){
		this.matter=matter;
	}
	
	public String getMatter() {
		return this.matter;
	}
}
