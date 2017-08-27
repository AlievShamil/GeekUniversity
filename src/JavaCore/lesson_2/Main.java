package JavaCore.lesson_2;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {

        String[][] arr = new String[4][4]; //
        fillArray(arr);

//        arr[1][1] = "qwerty"; // Принудительный MyArrayDataException

        try {
            processingArrayAndPrint(arr);
        } catch (MyArraySizeException | MyArrayDataException ex) {
        }

    }

    // Может стоило все записать в этом методе, а не делить на несколько...
    private static void processingArrayAndPrint(String[][] strArray) {
        checkArrayForDimensions(strArray);
        System.out.println(String.format("Сумма всех элементов массива равна - %s",
                checkCellAndSummarize(strArray)));
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
    private static BigInteger checkCellAndSummarize(String[][] strArray) {
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
