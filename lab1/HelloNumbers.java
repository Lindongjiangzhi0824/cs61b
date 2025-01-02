public class HelloNumbers {
    public static void Triangle(int num) {
        for(int i = 1 ; i <= num ; i++) {
            for(int j = 0 ; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Triangle(5);

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(arr[3]);
    }
}

