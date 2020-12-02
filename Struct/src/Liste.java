
public class Liste<T> {
	private T Ele;
	
	private Liste<T> succ;
	
	public Liste(T Elem) {
		this.Ele = Elem;
		this.succ = null;
	}
	public Liste(T Elem, Liste<T> next) {
		this.Ele = Elem;
		this.succ = next;
	}
	public T getEle() {
		return Ele;
	}
	public void setEle(T ele) {
		Ele = ele;
	}
	public Liste<T> getSucc() {
		return succ;
	}
	public void setSucc(Liste<T> succ) {
		this.succ = succ;
	}
	public void addC (T NvEle) {
		Liste<T> li = new Liste<T>(this.Ele, this.succ);
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
	public void addEnd(T NvEle) {
		Liste<T> L = this;
		while(L.succ != null) {
			L = L.succ;
		}
		L.succ = new Liste<T>(NvEle);
	}
	
	
}
