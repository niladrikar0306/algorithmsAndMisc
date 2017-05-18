package findarray2;

public class MyFindArray implements FindArray {
    public int findArray(int[] array, int[] subArray) {
        int i=0,j=0,k=0,index=-1;
        if(subArray.length==0){
        	return -1;
        }
        
        for(i=0;i<array.length;i++){
            if(array[i]==subArray[0]){
                index = i;
                for(j=i+1,k=0+1;j<array.length && k<subArray.length;j++,k++){
                	if(array[j]!=subArray[k]){
                		index = -1;
                		break;
                	}
                }
                if(subArray.length!=1 && k!=subArray.length){
                	index=-1;
                }
            }
        }
        return index; 
    }
}