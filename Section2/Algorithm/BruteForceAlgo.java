package CodeStates.Section2.Algorithm;

public class BruteForceAlgo {

    public static int bfMatching(String text, String pattern){
        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex!=text.length()&& patternIndex!=pattern.length()){
            // 같은 문자를 발견했을때 text와 pattern의 인덱스 값을 증가 시키며 다시 탐색
            if(text.charAt(textIndex)==pattern.charAt(patternIndex)){
                textIndex++;
                patternIndex++;
            } else {
                // 같은 문자가 없다면 textIndex의 값은 1씩 증가하게 되고.
                // 같은 문자열을 찾았을때, pattern의 마지막 문자와 같은 text의 인덱스에서 탐색을 끝낸 상태라면.
                // pattern의 첫번째 문자가 포함된 text의 인덱스를 textIndex에 삽입.
                textIndex = textIndex - patternIndex + 1;
                patternIndex = 0;
            }
        }
        // 같은 문자열을 찾았을때 첫 문자 인덱스값을 반환
        if(patternIndex == pattern.length()) return textIndex-patternIndex;
        // 그렇지 않은 경우 -1 반환
        else return -1;
    }

    public int[] SelectionSort(int[] arr) {
        // 요소를 가지고 전체 배열을 순회하며 최소값을 찾아 교환한다.
        for (int from = 0; from < arr.length - 1; from++) {
            // 요소중 최소값의 인덱스를 가질 변수 min
            int min = from;
            for (int j = from + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // from 인덱스 값을 가진 요소를 최소값과 교환한다.
            swap(arr,from,min);
        }
        return arr;
    }

    public void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i=0; i<n-1; i++){
            // 더이상 정렬할 요소가 있는지 없는지 확인 count
            int count =0;
            // 배열의 끝부터 인덱스 i 까지 탐색하며 요소 교환
            for(int t=n-1; t>i; t--){
                if(arr[t-1]>arr[t]) {
                    swap(arr,t-1,t);
                    count++;
                }
            }
            // 더이상 탐색해서 교환하는 요소가 없다면 break
            if(count == 0) break;
        }
    }
    private void swap(int[] arr, int idx, int idx2){
        int temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int binarySearch(int[] arr, int key){
        // 탐색할 구간의 제일 처음 인덱스값 저장
        int pre = 0;
        // 탐색할 구간의 제일 끝 인덱스값 저장
        int end = arr.length-1;
        // pre 값이 end 값보다 커지면 종료.
        while (pre<=end) {
            // 탐색할 구간의 중간 인덱스값 저장.
            int center = (pre+end)/2;
            // 중간 인덱스값을 가진 요소가 key 같다면 해당 인덱스 반환 후 종료
            if(arr[center]==key){
                return center;
            // 중간 인덱스 값을 가진 요소가 key 값보다 작다면,
            }else if (arr[center]<key){
                // 다음 탐색할 구간의 제일 처음 인덱스 값을 중간 인덱스 값 +1로 저장.
                pre = center+1;
                // 중간 인덱스 값을 가진 요소가 key 값보다 크다면,
                // 다음 탐색할 구간의 제일 마지막 인덱스를 중간 인덱스 값 -1로 저장.
            }else end = center-1;
        }
        // 찾지 못했다면 -1 반환
        return -1;
    }
    public static int binarySearchRecursive(int[] arr, int key, int pre, int end) {
        // pre 탐색할 구간의 제일 처음 인덱스 값 저장.
        // end 탐색할 구간의 제일 마지막 인덱스 값 저장.
        if (pre > end)
            return -1;

        int center = (pre + end) / 2;
        if (arr[center] == key)
            return center;
        else if (arr[center] > key)
            return binarySearchRecursive(arr, key, pre, center-1);
        else
            return binarySearchRecursive(arr, key, center+1, end);
    }

    public static void main(String[] args) {
        int [] a = new int[191];
        for(int i=0; i<191; i++){
            a[i]= i;
        }
        System.out.println(binarySearchRecursive(a,102,0,a.length));

    }
}
