import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Cho trước ma trận a, kích thước m x n. Tính tổng các phần tử trên:

        int[][] a = inputMatrix();
        printMatrix(a);

        //Bài 4a: Dòng d, cột c
        int sumDC = sumDongCot(a, 1, 1);
        System.out.println("Tổng dòng và cột = " + sumDC);

        //Bài 4b: Đường chéo chính, đường chéo phụ (ma trận vuông)
        int sumCheoChinh = sumDuongCheoChinh(a);
        System.out.println("Tổng đường chéo chính = " + sumCheoChinh);
        int sumCheoPhu = sumDuongCheoPhu(a);
        System.out.println("Tổng đường cheo phụ = " + sumCheoPhu);

        //Bài 4c: Nửa trên/dưới đường chéo chính (ma trận vuông)
        int sumNuaTrenCheoChinh = sumNuaTrenCheoChinh(a);
        System.out.println("Tổng nửa trên chéo chính = " + sumNuaTrenCheoChinh);
        int sumNuaDuoiCheoChinh = sumNuaDuoiCheoChinh(a);
        System.out.println("Tổng nửa dưới chéo chính = " + sumNuaDuoiCheoChinh);

        //Bài 4d: Nửa trên/dưới đường chéo phụ (ma trận vuông)
        int sumNuaTrenCheoPhu = sumNuaTrenCheoPhu(a);
        System.out.println("Tổng nừa trên chéo phụ = " + sumNuaTrenCheoPhu);
        int sumNuaDuoiCheoPhu = sumNuaDuoiCheoPhu(a);
        System.out.println("Tổng nửa dưới chéo Phụ = " + sumNuaDuoiCheoPhu);

        // Bài 1
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập vào số cần kiểm tra: ");
//        int n = sc.nextInt();
//        if (checkNumber(a, n)) {
//            System.out.format("Có %d trong ma trận.", n);
//        } else System.out.format("Không có %d trong ma trận.", n);
//        System.out.println();
//
//        //Bài 2
//        if (checkPrime(a)) {
//            System.out.println("Đây là mảng toàn số nguyên tố.");
//        } else System.out.println("Đây là mảng ko phải toàn số nguyên tố");
//
//        //Bài 3
//        int max = maxArr(a);
//        System.out.format("Phần tử có giá trị lớn nhất là %d", max);
////        int[][] a = generateMatrix(4, 5, 1, 50);
//
////        int sum = sumElements(a);
////        System.out.format("SUM = %d\n ", sum);
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

    public static int sumDongCot(int[][] a, int dong, int cot) {
        int sum = 0;
        for (int i = 0; i <= dong; i++) {
            for (int j = 0; j <= cot; j++) {
                if (i == dong || j == cot) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

//    public static int sumRowAndComlumn(int[][] a, int r0, int c0) {
//        //
//        int sum = 0;
//
//        for (int c = 0; c < a[r0].length; c++) {
//            sum += a[r0][c];
//        }
//
//        for (int r = 0; r < a.length; r++) {
//            sum += a[r][c0];
//        }
//
//        sum -= a[r0][c0];
//
//        return sum;
//    }

    public static int sumDuongCheoChinh(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
//                if(i == 0 && j ==0 || i == a.length && j == a.length|| i ==a.length/2 && j ==a.length/2)
                if (i == j) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumDuongCheoPhu(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i + j == r - 1) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumNuaTrenCheoPhu(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i + j < r) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumNuaDuoiCheoPhu(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (i + j >= r) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumNuaTrenCheoChinh(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (j - i >= 0) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumNuaDuoiCheoChinh(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (j - i < 0) {
                    sum += a[i][j];
                }
            }
        }
        return sum;
    }
}
