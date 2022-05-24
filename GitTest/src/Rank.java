
public class Rank {
	
	public void rank() {
	int[] arr = {};
	int[] rank = {1,1,1,1,1};
	
	for (int i = 0; i < rank.length; i++) {
		for (int j = 0; j < arr.length; j++) {
			if(arr[i]<arr[j]) {
				rank[i]++;
			}
		}
	}
	System.out.println("[·©Å·]");
	int[] index= new int[rank.length];
	for (int i = 0; i < rank.length; i++) {
		index[rank[i]-1] = i;
	}
	for (int i = 0; i < rank.length; i++) {
		int a = index[i];
		System.out.println(rank[a]+"µî"+"\t"+arr[a]);
	}
}
}