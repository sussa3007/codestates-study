package CodeStates.Section1.JavaBasicStudy.src;

import java.util.Arrays;

public class ArrayStudy {
    public static int getFirstElement(int[] arr) {

        if (arr.length == 0) {
            return -1;
        } else return arr[0];
    }

    public static int getLastElement(int[] arr) {
        if (arr.length == 0) {
            return -1;
        } else return arr[arr.length - 1];
    }

    public static int getNthElement(int[] arr, int index) {
        if (arr.length == 0) {
            return -1;
        } else if (index >= arr.length) {
            return -2;
        } else return arr[index];

    }

    public static int computeSumOfAllElements(int[] arr) {
        if (arr.length == 0) return 0;
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            a += arr[i];
        }
        return a;
    }

    public static String[] getAllWords(String str) {
        String[] arr = str.split(" ");
        if (str.isEmpty()) {
            return new String[]{};
        } else return arr;
    }

    public static char[] getAllLetters(String str) {
        if (str.isEmpty()) return new char[]{};
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public int getLargestElement(int[] arr) {
        int result = arr[0];
        for (int i : arr)
            if (i > result) {
                result = i;
            }
        return result;
    }

    public String getLongestWord(String str) {
        String[] arr = str.split(" ");
        String result = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > result.length()) {
                result = arr[i];
            }
        }
        return result;
    }

    public static int[] getEvenNumbers(int[] arr) {
//        if (arr.length==0) return new int[]{};
//        int c = 0;
//        for(int i= 0; i<arr.length; i++){
//            if(arr[i]%2==0)
//                c++;
//        }
//        int[] evenarr = new int[c];
//        c = 0;
//        for (int i=0; i<arr.length; i++){
//            if (arr[i]%2==0){
//                evenarr[c] =arr[i];
//                c++;
//            }
//        }
//        return evenarr;
        int[] a = new int[]{};
        for (int i = 0; i < arr.length; i++) {
            a = Arrays.copyOf(a, a.length + 1);
            a[a.length - 1] = arr[i];
        }
        return a;

    }

    public static int[] addToFront(int[] arr, int el) {
        int[] elarr = new int[arr.length + 1];
        System.arraycopy(arr, 0, elarr, 1, arr.length);
        elarr[0] = el;
        return elarr;

    }

    public int[] addToBack(int[] arr, int el) {
        int[] elarr = Arrays.copyOf(arr, arr.length + 1);
        elarr[arr.length - 1] = el;
        return elarr;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] addarr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, addarr, 0, arr1.length);
        System.arraycopy(arr2, 0, addarr, arr1.length, arr2.length);
        return addarr;
    }

    public static int[] getElementsAfter(int[] arr, int n) {
        if (arr.length == 0 || arr.length <= n) return new int[]{};
        int[] cutarr = Arrays.copyOfRange(arr, n, arr.length);
        return cutarr;
    }

    public static int[] getElementsUpTo(int[] arr, int n) {
        if (arr.length == 0 || arr.length <= n) return new int[]{};
        int[] frontarr = Arrays.copyOfRange(arr, 0, n);
        return frontarr;
    }

    public static int[] getAllElementsButFirst(int[] arr) {
        if (arr.length == 0) return new int[]{};
        int[] firstarr = Arrays.copyOfRange(arr, 1, arr.length);
        return firstarr;
    }


    public String createPhoneNumber(int[] arr) {
        String head = "010";
        int len = arr.length;
        String bodyArr = Arrays.toString(Arrays.copyOfRange(arr, len - 8, len - 4)); // 뒤에서 계산하면 입력 길이에 상관없이 계산가능  
        String body = bodyArr
                .replaceAll(" ", "")
                .replaceAll(",", "")
                .replace("[", "")
                .replace("]", "");
        String tailArr = Arrays.toString(Arrays.copyOfRange(arr, len - 4, len));
        String tail = tailArr
                .replaceAll(" ", "")
                .replaceAll(",", "")
                .replace("[", "")
                .replace("]", "");

        if (len == 11) {
            String headArr = Arrays.toString(Arrays.copyOfRange(arr, 0, 3));
            head = headArr
                    .replaceAll(" ", "")
                    .replaceAll(",", "")
                    .replace("[", "")
                    .replace("]", "");
        }
        return String.format("(%s)%s-%s", head, body, tail);
    }

    public static int[] fibonacci(int num) {
        int[] array = new int[num + 1];

        for(int i = 0; i <= num; i++) {
            if(i <= 1) {
                array[i] = i;
            }else {
                array[i] = array[i - 2] + array[i - 1];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        int[] arr2 = {0, 9, 8, 7, 8, 9};
//        ArrayStudy.createPhoneNumber(arr1);

        System.out.println(Arrays.toString(getAllElementsButFirst(arr2)));
        System.out.println("arr2 = " + Arrays.toString(arr2));


    }
}
