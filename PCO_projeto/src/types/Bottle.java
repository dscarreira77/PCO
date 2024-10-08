package types;

import java.util.Iterator;


//Notem que podem faltar métodos na classe que permitam lidar melhor com os objectos.
public class Bottle implements Iterable<Filling>{


	public static int DEFAULT_SIZE = 5;

	public static String empty = "⬜";

	public static String EOL = System.lineSeparator();
	
	private Filling[] content;
	
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
		for(int i = content.length-1;i>= 0; i--){
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
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Bottle is empty");
		}
	
		for (int i = content.length - 1; i >= 0; i--) {
			if (content[i] != null) {
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
		int i = content.length-1;
		int count = 0;
		while (i >= 0 && count < n){
			if(content[i] != null){
				content[i] = null;
				count++;
			}else{
				i--;
			}
		}

	}

	/**
	 * 
	 */
	public void pourOut() {
		int i = content.length-1;
		while (i >= 0){
			if(content[i] != null){
				content[i] = null;
				i = -1;
			}else{
				i--;
			}
		}
	}


	/**
	 * 
	 * @param s
	 * @param howMany
	 * @return
	 */
	public boolean receive(Filling s, int howMany) {
		int count = 0;
		for(int i = content.length-1 ; i > 0; i--){
			if((content[i] == null && s == content[i-1]) || (content[0] == null)){
				content[i] = s;
				if(count == howMany -1 ){
					return true;
				}else{
					count--;
				}
			}
		}
		return false;
	}


	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean receive(Filling s) {
        for (int i = 0; i < content.length; i++) {
            if (content[i] == null) {
                content[i] = s;
                return true;
            }
        }
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
		Filling primeiro = content[0];
		for(int i = 1; i < content.length-1;i++){
			if(primeiro != content[i] && content[i] != null){
				return false;
			}
		}
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
	public String toString() {
		StringBuilder result = new StringBuilder();
	
		for (int i = content.length - 1; i >= 0; i--) {
			if (content[i] != null) {
				result.append(content[i]);
				result.append(EOL);
			} else {
				result.append(empty);
				result.append(EOL);
			}
		}
	
		return result.toString();
	}
	
	
	
	

	/**
	 * 
	 */
	public Iterator<Filling> iterator() {
		return null;
	}


}
