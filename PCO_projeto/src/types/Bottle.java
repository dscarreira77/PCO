package types;

import java.util.Iterator;


//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class Bottle implements Iterable<Filling>{


	public static int DEFAULT_SIZE = 5;

	public static String empty = "⬜";

	public static String EOL = System.lineSeparator();
	
	private Filling[] content;

	public static void main(String[] args) {
		// Defina a codificação UTF-8 para garantir a exibição correta dos caracteres Unicode
		System.setProperty("file.encoding", "UTF-8");
	
		Filling[] initialContent = { Squares.YELLOW, Squares.BROWN, null, null, null };
		Bottle bottle = new Bottle(initialContent);
	
		// Testando o método toString2()
		System.out.println(bottle.toString2());
	}
	
	/**
	 * 
	 */
	public Bottle() {
		content = new Filling[DEFAULT_SIZE];
	}
	/**
	 * 
	 * @param size
	 */
	public Bottle(int size) {
		content = new Filling[size];
	}


	/**
	 * @param content
	 */
	public Bottle(Filling[] content ) {
		this.content= content;
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		for(int i=0; i<content.length; i++){
			if(content[i] == null){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		for(int i = content.length;i>= 0; i--){
			if(content[i] != null){
				return false;
			}		
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Filling top() {
		for(int i = content.length; i>=0;i--){
			if(content[i] != null){
				return content[i];
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public int spaceAvailable() {
		int count = 0;
		for(int i = 0; i< content.length;i++){
			if(content[i] == null){
				count++;
			}
		}
		return count;
	}

	/**
	 * 
	 * @param n
	 */
	public void pourOut(int n) {
	}

	/**
	 * 
	 */
	public void pourOut() {

	}


	/**
	 * 
	 * @param s
	 * @param howMany
	 * @return
	 */
	public boolean receive(Filling s, int howMany) {
		return false;
	}


	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean receive(Filling s) {
		return false;

	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return content.length;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSingleFilling() {
		return true;
	}



	/**
	 * 
	 * @return
	 */
	public Filling[] getContent() {

		return content;
	}


	/**
	 * 
	 */
	public String toString2() {
		StringBuilder result = new StringBuilder();
	
		for (int i = content.length - 1; i >= 0; i--) {
			if (content[i] != null) {
				result.append(content[i].toString()).append(" ");
			} else {
				result.append(empty).append(" null ");
			}
		}
	
		return result.toString().trim(); // Remove espaços em branco extras no início e no final.
	}
	
	

	/**
	 * 
	 */
	public Iterator<Filling> iterator() {
		return null;
	}


}
