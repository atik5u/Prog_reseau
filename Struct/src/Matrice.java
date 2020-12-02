
public class Matrice {
	private int [] tab ;
	public Matrice(int N) {
		// TODO Auto-generated constructor stub
		tab = new int [N];
	}
	public void creatTab(int N, int r) {
		// la creation de tab qui a des valeurs entre 1 et r
		
		for(int i=0; i<N; i++) {
			tab[i] = (int)(Math.random() * r + 1);
		}
	}

	public void printTab(int N) {
		for(int i=0; i<N; i++) 
			System.out.print("T["+i+"] = "+tab[i]+ "  " );
		System.out.println("");
	}
	public int max(int a, int b) {
		if (tab[a]>tab[b]) {
			return a;
		}else {
			return b;
		}
	}
	public int ifd (int i) {
		return i*2 + 2;
	}
	public int ifg (int i) {
		return i*2 + 1;
	}
	public int ipere (int i) {
		return (i-1)/ 2;
	}

	public void TableToTas(int deb) {
			if(deb < this.tab.length/2) {
				int imax;
				if(ifd(deb)<this.tab.length) {
					imax= max(ifg(deb), ifd(deb));
				}else {
					imax = ifg(deb);
				}
				
				if(tab[deb] < tab[imax] ) {
					int inte = tab[deb];
					tab[deb] = tab[imax];
					tab[imax] = inte;
					if(ipere(deb)>= 0) {
						if(tab[deb] > tab[ipere(deb)] ) {
							int inter1 = tab[ipere(deb)];
							tab[ipere(deb)] = tab[deb];
							tab[deb] = inter1;
						}
						
					}
				
				}
				TableToTas(deb+1);
			}

		
	}
	
	public void fix(int i, int n) {
		if(i < this.tab.length/2) {
			int imax;
			if(ifd(i)<this.tab.length) {
				imax= max(ifg(i), ifd(i));
			}else {
				imax = ifg(i);
			}
			
		}
	}
	public static void main(String[] args) {
		int N = 10;
		int r= 30;
		Matrice M= new Matrice(N);
		M.creatTab(N, r);
		M.printTab(N);
		M.TableToTas(0);
		M.printTab(N);
	}
}
