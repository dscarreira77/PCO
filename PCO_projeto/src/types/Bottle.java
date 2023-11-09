package types;

import java.util.Iterator;

//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class Bottle implements Iterable<Filling>{


	public static int DEFAULT_SIZE = 5;

	public static String empty = "⬜";

	public static String EOL = System.lineSeparator();

	/**
	 * 
	 */
	public Bottle() {
	}

	/**
	 * 
	 * @param size
	 */
	public Bottle(int size) {
	}


	/**
	 * @param content
	 */
	public Bottle(Filling[] content ) {
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public Filling top() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public int spaceAvailable() {
		return 0;	
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
		return 0;
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
