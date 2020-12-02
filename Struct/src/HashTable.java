import java.util.Arrays;

public class HashTable<T> {
private int size;
private Object [] alveoles;

public HashTable(int size) {
	// TODO Auto-generated constructor stub
	this.size = size;
	this.alveoles = new Object [size];
}
public static int hash(String clef ) {
	int U=0;
	for(int i=0; i<clef.length(); i++) {
		//cast (int) veux dire la resultat de clef.charAt(i) va etre un entier
		U+= (int)clef.charAt(i);
	}
	return U;
}	
public void add(T Obj, String clef) {
	int hash = hash (clef)%this.size;
	if(this.alveoles[hash] == null) {
		alveoles[hash] = new TableDeHachage<T>(Obj,clef);
	}else {
		((TableDeHachage<T>)this.alveoles[hash]).addEnd(Obj, clef);
	}
	
}
public T get (String clef) {
	int find = hash(clef)% this.size;
	if(this.alveoles[find] == null) {
		return null;
	}else {
		return ((TableDeHachage<T>)this.alveoles[find]).find(clef);
	}
	
}
@Override
public String toString() {
	return "HashTable [size=" + size + ", alveoles=" + Arrays.toString(alveoles) + "]";
}



}
