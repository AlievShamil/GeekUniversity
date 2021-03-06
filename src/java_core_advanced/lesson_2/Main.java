package java_core_advanced.lesson_2;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {

        String[][] arr = new String[4][4]; // вот тут может возникнуть MyArraySizeException
        fillArray(arr);

        arr[1][1] = "qwerty"; // Принудительный MyArrayDataException

        try {
            processingArrayAndPrint(arr);
        } catch (MyArraySizeException | MyArrayDataException ex) {
        }

    }

    // Может стоило все записать в этом методе, а не делить на несколько...
    private static void processingArrayAndPrint(String[][] strArray) {
        checkArrayForDimensions(strArray);
        String str = String.format("Сумма всех элементов массива равна - %s", checkCellAndSummarize(strArray));
//        String strBig = String.format("Сумма всех элементов массива равна - %s", checkCellAndSummarize(strArray));
        System.out.println(str);
    }

    // Проверка на размерность
    private static void checkArrayForDimensions(String[][] strArray) {
        if (strArray.length == 4) {
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].length != 4)
                    throw new MyArraySizeException();
            }
        } else
            throw new MyArraySizeException();

    }

    // Метод проверки ячейки и вычисления суммы всех ячеек
    private static int checkCellAndSummarize(String[][] strArray) {
        int result = 0;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                if (strArray[i][j] != null && strArray[i][j].matches("[\\d]+")) {
                    int temp = Integer.parseInt(strArray[i][j]);
                    result += temp;
                } else
                    throw new MyArrayDataException(i, j);
            }
        }
        return result;
    }


    // Аналог checkCellAndSummarize() для огромных чисел
    private static BigInteger checkCellAndSummarizeBig(String[][] strArray) {
        BigInteger bigNum = BigInteger.ZERO;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                if (strArray[i][j] != null && strArray[i][j].matches("[\\d]+"))
                    bigNum = bigNum.add(new BigInteger(strArray[i][j]));
                else
                    throw new MyArrayDataException(i, j);
            }
        }
        return bigNum;
    }

    // Заполняем массив для теста
    private static void fillArray(String[][] strArray) {
        int num = 1;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                strArray[i][j] = String.format("%s", num++);
            }
        }
    }

}
