/**
 * Sorts an array of integers in ascending order.
 *
 * @author Andrej Chomutovskij
 */
public class MergeSort
{
    /**
     * Sorts an array of integers in ascending order.
     *
     * @param array An array of integers.
     * @return A sorted in ascending order array of integers.
     */
    public static int[] sort(int[] array)
    {
        if (array.length <= 1) {
            return array;
        }

        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = array[i + left.length];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            }
            else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while(leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }


        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] array = new int[] {5, 10, 4, 2, 47, 60, 40, 1447, 3};
        int[] sortedArray = sort(array);

        for (int value : array) {
            System.out.printf("%d ", value);
        }
        System.out.println();

        for (int value : sortedArray) {
            System.out.printf("%d ", value);
        }
        System.out.println();
    }
}