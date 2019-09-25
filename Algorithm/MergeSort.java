import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 
public class MergeSort {

	static int size; // ������ ���� ���� ����
	static List<Integer> list; // ������ ���� ����Ʈ
    static int[] sortedList; // ���ĵǴ� ����
    
    public static void main(String[] args) {
    	// ���� ������ ����Ʈ �Է�
    	System.out.println("������ ����Ʈ�� ����� �Է��ϼ���.");
    	Scanner sc = new Scanner(System.in);
    	size = sc.nextInt();
    	list = new ArrayList<>();
    	
    	System.out.println("����Ʈ�� �μ��� ���ʷ� �Է��ϼ���.");
    	for(int i=0; i<=size-1; i++) {
    		list.add(sc.nextInt());
    	}
    	
    	sc.close();
    	
        
    	// ���� ���� ����
        System.out.println("���� ���� ��: "+ list.toString());
        System.out.println("-----------------���� ���� ����------------------");
        
        if(size==1) {
        	System.out.println("���� ���� ��: "+ list.toString());
    	}else{
        sortedList = new int[size];
        mergeSort(list, 0, size-1);
    	}
    }
    
    public static void mergeSort(List<Integer> list, int begin, int end) {
        int middle;
        if(begin<end) {
            middle = (begin+end)/2;
            mergeSort(list, begin, middle);    // begin�� ���� ���� �۾� ����
            mergeSort(list, middle+1, end);    // end�� ���� ���� �۾� ����
            merge(list, begin, middle, end);   // �κ����տ� ���Ͽ� ���İ� ���� �۾� ����
        }
    }
    
    public static void merge(List<Integer> list, int begin, int middle, int end) {
        int i = begin;             // ù ��° �κ������� ���� ��ġ ����
        int j = middle+1;     // �� ��° �κ������� ���� ��ġ ����
        int k = begin;             // �迭 sorted�� ���ĵ� ���Ҹ� ������ ��ġ ����
        
        while(i<=middle && j<=end) {
            if(list.get(i)<=list.get(j)) {
                sortedList[k] = list.get(i);
                i++;
            }else {
                sortedList[k] = list.get(j);
                j++;
            }
            k++;
	        }
	        if(i>middle) {
	            for(int t=j;t<=end;t++,k++) {
	                sortedList[k] = list.get(t);
	            }
	        }else {
	            for(int t=i;t<=middle;t++,k++) {
	                sortedList[k] = list.get(t);
	            }
	        }
	        
	        for(int t=begin;t<=end;t++) {
	            list.set(t, sortedList[t]);
	        }
	        System.out.println("���� ���� ��: "+ list.toString());
    }
        
}