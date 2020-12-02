
public class ABR<K extends Comparable<K>, T> implements BinarySearchTree<K, T> {
	private K clef;
	private T Element;
	private ABR<K, T> FG;
	private ABR<K, T> FD;

	public ABR(K clef, T Element) {
		// TODO Auto-generated constructor stub
		this.clef = clef;
		this.Element = Element;
		FG = null;
		FD = null;
	}

	@Override
	public void add(K clef, T element) {
		// TODO Auto-generated method stub
		if (clef.compareTo(this.clef) >= 0) {
			if (this.FD != null) {
				add(this.FD.clef, element);
			} else {
				FG = new ABR<K, T>(clef, element);
			}

		} else {
			if (this.FG != null) {
				add(this.FG.clef, element);
			} else {
				FG = new ABR<K, T>(clef, element);
			}
		}

	}

	@Override
	public boolean is_in(K clef) {
		// TODO Auto-generated method stub
		if(this.clef.compareTo(clef)==0) {
			return true;
		}
		if(clef.compareTo(this.clef)>= 0) {
			if(this.FD != null) {
				return is_in(FD.clef);
			}else {
				return false;
			}
			
		}else {
			if(this.FG != null) {
				return is_in(FG.clef);
			}else {
				return false;
			}
		}
	
	}
	
	@Override
	public T get(K clef) {
		if(this.clef.compareTo(clef)==0) {
			return this.Element;
		}
		if(clef.compareTo(this.clef)>= 0) {
			if(this.FD != null) {
				return get(FD.clef);
			}else {
				return null;
			}
			
		}else {
			if(this.FG != null) {
				return get(FG.clef);
			}else {
				return null;
			}
		}
	}


	@Override
	public String toString() {
		return "ABR [clef=" + clef + ", Element=" + Element + ", FG=" + FG + ", FD=" + FD + "]";
	}
	
}
