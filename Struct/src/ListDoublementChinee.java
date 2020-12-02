public class ListDoublementChinee<T> extends Liste<T>{
	
	public ListDoublementChinee(T Elem) {
		super(Elem);
		// TODO Auto-generated constructor stub
	}
	public ListDoublementChinee(ListDoublementChinee<T> prev, Liste<T> L, T ele) {
		// TODO Auto-generated constructor stub
		super(ele);
	}

	public Liste<T> getPred() {
		return pred;
	}
	public void setPred(Liste<T> pred) {
		this.pred = pred;
	}

	private Liste<T> pred;
	
	
	

}
