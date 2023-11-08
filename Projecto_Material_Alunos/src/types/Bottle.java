package types;

import java.util.Iterator;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class Bottle implements Iterable<Filling>{


	public static int DEFAULT_SIZE = 5;

	public static String empty = "⬜";

	public static String EOL = System.lineSeparator();
	
	private Filling[] content;

	public static void main(String[] args) {

		Emojis[] vec = new Emojis[7];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = Emojis.ANGEL;
		}

		Bottle bottleTest = new Bottle(vec);;
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
		System.out.println(this.content);
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

		return null;
	}


	/**
	 * 
	 */
	public String toString() {

		return null;

	}

	/**
	 * 
	 */
	public Iterator<Filling> iterator() {
		return null;
	}


}
