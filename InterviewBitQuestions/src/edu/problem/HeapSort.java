package edu.problem;

public class HeapSort {

	public static void main(String[] args) {
		HeapSort h=new HeapSort();
		int a[]= {9,6,5,0,8,2,7,1,3};
		h.heapSortAsc(a);
		System.out.println();
		h.heapSortDesc(a);

	}
	
	public void heapSortDesc(int ar[]) {
		for(int i=(ar.length/2)-1;i>=0;i--) {
			minHeap(ar, ar.length, i);
		}
		for(int i=ar.length-1;i>=0;i--) {
			swap(ar,i,0);
			minHeap(ar, i, 0);
		}
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
	}
	
	public void heapSortAsc(int[] ar) {
		for(int i=(ar.length/2)-1;i>=0;i--) {
			maxHeap(ar,ar.length,i);
		}
		for(int i=ar.length-1;i>=0;i--) {
			swap(ar,i,0);
			maxHeap(ar,i,0);
		}
		
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
	}
	
	public void maxHeap(int[] ar, int n, int i) {
		int l=2*(i+1)-1, r=2*(i+1);
		int largest=i;
		if(l<n && ar[l]>ar[i])
			largest=l;
		if(r<n && ar[r]>ar[largest])
			largest=r;
		if(largest!=i) {
			swap(ar,largest,i);
			maxHeap(ar, n, largest);
		}
	}
	
	public void minHeap(int[] ar, int n, int i) {
		int l=2*(i+1)-1, r=2*(i+1),smallest=i;
		if(l<n && ar[l]<ar[i])
			smallest=l;
		if(r<n && ar[r]<ar[l])
			smallest=r;
		if(smallest!=i) {
			swap(ar,i, smallest);
			minHeap(ar,n,smallest);
		}
	}
	
	public void swap(int[] ar, int i, int j) {
		int temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
	}

}
