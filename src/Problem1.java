public class Problem1 {
    public int countFreqBrute(int key, int [] A){
        if (A == null || A.length == 0)
        return 0;

        int count = 0;
        for(int value : A){
            if (value == key) {
                count++;
            }else if (value > key){
                break;
            }
        }
        return count;    
    }

    public int countFreqSmart(int key, int [] A){
        if (A == null || A.length == 0)
        return 0;

        int first = findFirstOccurrence(A, key);
        if (first == -1) 
            return 0;

        int last = findLastOccurrence(A, key);
        return last - first + 1;
    }

    private int findFirstOccurrence(int[] A, int key){
        int low = 0;
        int high = A.length - 1;
        int result = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(A[mid] == key){
                result = mid;
                high = mid -1;
            }else if(A[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    private int findLastOccurrence(int[] A, int key){
        int low = 0;
        int high = A.length - 1;
        int result = -1;

        while(low <= high){
            int mid = low +(high - low)/2;
            if(A[mid] == key){
                result = mid;
                low = mid + 1;
            }else if(A[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    static void main() {
        Problem1 p1 = new Problem1();

        int[] A = {1, 1, 1, 2, 2, 2, 2, 2, 2, 4, 4, 4, 5, 5, 5, 5};
        int key = 4;

        System.out.println("Problem1 Brute: " + p1.countFreqBrute(key, A)); 
        System.out.println("Problem1 Smart: " + p1.countFreqSmart(key, A));
    }
}
