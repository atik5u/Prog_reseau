
public class TableDeHachage<T> {
	private T Ele;
	private String clef;
	private TableDeHachage<T> succ;
	
	public TableDeHachage(Object obj, String clef) {
		this.Ele = (T) obj;
		this.clef = clef;
		this.succ = null;
	}
	public TableDeHachage(T Elem, TableDeHachage<T> next, String clef) {
		this.Ele = Elem;
		this.succ = next;
		this.clef = clef;
	}
	public T getEle() {
		return Ele;
	}
	public void setEle(T ele) {
		Ele = ele;
	}
	public TableDeHachage<T> getSucc() {
		return succ;
	}
	public void setSucc(TableDeHachage<T> succ) {
		this.succ = succ;
	}
	public void addC (T NvEle,String clef) {
		TableDeHachage<T> li = new TableDeHachage<T>(this.Ele, this.succ,this.clef = clef);
		this.setEle(NvEle);
		this.setSucc(li);
	}
	public String afficher() {
		String S = "";
		while(this.succ != null) {
			S+= this.getSucc() + "   " ;
		}
		return S;
	}
	public void addEnd(T NvEle, String clef) {
		TableDeHachage<T> L = this;
		while(L.succ != null) {
			L = L.succ;
		}
		L.succ = new TableDeHachage<T>(NvEle, clef);
	}
	
	public T find(String clef) {
		if (this.clef.equals(clef)) {
			return this.Ele;
		}else if(this.succ != null) {
			return this.succ.find(clef);
		}else {
			return null;
		}
	
		
	}
	@Override
	public String toString() {
		return "TableDeHachage [Ele=" + Ele + ", clef=" + clef + ", succ=" + succ + "]";
	}
	


}
