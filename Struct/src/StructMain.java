
public class StructMain <K extends Comparable<K>, T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Prenom = "Abir";
		Integer num = 9;
		String Prenom1 = "Atik";
		Integer num2 = 3;
		HashTable<Integer> H = new HashTable<Integer>(1);
		ABR<String, Integer> Tree = new ABR<String,Integer>(Prenom, num);
		
		Tree.add(Prenom1, num2);
		Tree.add("hhh", 4);
		Tree.add("hhhdasf", 8);
		System.out.println(Tree.get("Abir"));
		System.out.println(Tree.is_in("fghfsd"));
		System.out.println(Tree);
		System.out.println(H);
		H.add(num, Prenom);
		System.out.println(H);
		H.add(num2, Prenom1);
		System.out.println(H);
		System.out.println(H.get(Prenom));
	}

}
