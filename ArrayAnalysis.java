import java.util.Scanner;
import java.util.Arrays;

public class ArrayAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Accept size
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // 2. Accept numbers
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // 3. Find Min and Max
        int min = arr[0];
        int max = arr[0];
        int total = 0;

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
            total += num;
        }

        // 4. Ascending Order
        int[] asc = arr.clone();
        Arrays.sort(asc);

        // 5. Descending Order
        int[] desc = arr.clone();
        Arrays.sort(desc);
        for (int i = 0; i < desc.length / 2; i++) {
            int temp = desc[i];
            desc[i] = desc[desc.length - 1 - i];
            desc[desc.length - 1 - i] = temp;
        }

        // 6. Average
        double avg = (double) total / size;

        // Output
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Ascending Order: " + Arrays.toString(asc));
        System.out.println("Descending Order: " + Arrays.toString(desc));
        System.out.println("Average: " + avg);
        
        sc.close();
        }
}