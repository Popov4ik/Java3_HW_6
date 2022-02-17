package Java3_HW_6;

public class TestMethod {

    public int[] toDeleteFour(int[] arr) {
        int count = 0;
        int[] arrayWithoutFour;
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            if (arr[i] == 4) {
                count = j;
                break;
            }
            if (i == 0) {
                throw new RuntimeException("Incoming array don't have a four");
            }
        }
        if (count == 0) {
            arrayWithoutFour = new int[count];
        } else {
            arrayWithoutFour = new int[count];
            System.arraycopy(arr, arr.length - count, arrayWithoutFour, 0, count);
        }
        return arrayWithoutFour;
    }

    public boolean TestOneAndFour(int[] arr) {
        int countOne = 0;
        int countFour = 0;
        for (int j : arr) {
            if (j != 1 && j != 4) {
                return false;
            }
            if (j == 1) {
                countOne++;
            }
            if (j == 4) {
                countFour++;
            }
        }
        return countOne != 0 && countFour != 0;
    }
}

