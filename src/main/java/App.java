import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[][] a = inputMatrix();
//        printMatrix(a);

        // Bài 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số cần kiểm tra: ");
        int n = sc.nextInt();
        if (checkNumber(a, n)) {
            System.out.format("Có %d trong ma trận.", n);
        } else System.out.format("Không có %d trong ma trận.", n);
        System.out.println();

        //Bài 2
        if (checkPrime(a)) {
            System.out.println("Đây là mãng toàn số nguyên tố.");
        } else System.out.println("Đây là mãng ko phải toàn số nguyên tố");

        //Bài 3
        int max = maxArr(a);
        System.out.format("Phần tử có giá trị lớn nhất là %d", max);
//        int[][] a = generateMatrix(4, 5, 1, 50);

//        int sum = sumElements(a);
//        System.out.format("SUM = %d\n ", sum);
    }

    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số dòng: ");
        int r = sc.nextInt();

        System.out.print("Số cột: ");
        int c = sc.nextInt();

        int[][] ret = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("a[%d][%d] = ", i, j);
                ret[i][j] = sc.nextInt();
            }
        }
        return ret;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                System.out.format("%5d ", a[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] generateMatrix(int r, int c, int min, int max) {
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = (int) Math.floor(Math.random() * (max - min) + min);
            }
        }
        return ret;
    }

    public static int sumElements(int[][] a) {
        int s = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                s += a[i][j];
            }

        }
        return s;
    }

    public static boolean checkNumber(int[][] a, int number) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPrime(int n) {
        boolean num = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                num = false;
                break;
            }
        }
        return num;
    }

    public static boolean checkPrime(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (!isPrime(a[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int maxArr(int[][] a) {
        int max = a[0][0];
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }
        return max;
    }
}
