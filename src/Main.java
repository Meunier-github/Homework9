
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Задача 1
        /*Бухгалтеры попросили посчитать сумму всех выплат за месяц.
        Создайте массив с пятью целочисленными элементами и задайте каждому элементу значение.
        Напишите программу, которая решит эту задачу, и выведите в консоль результат в формате:
         «Сумма трат за месяц составила … рублей».*/

        int[] costWeek = new int[5];
        try {
            Scanner costWeekInput = new Scanner(System.in);
            System.out.println("Введите расходы за ");
            int costMonth = 0;
            for (int i = 0; i < costWeek.length; i++) {
                System.out.print(i + 1 + " неделю: ");
                costWeek[i] = costWeekInput.nextInt();
                costMonth += costWeek[i];
            }


            System.out.println("Сумма трат за месяц составила " + Ruble(costMonth, "."));

            //Задача 2
        /*Также бухгалтерия попросила найти минимальную и максимальную траты за неделю.
          Создайте массив с пятью целочисленными элементами и задайте каждому элементу значение.
          Напишите программу, которая решит эту задачу, и выведите в консоль результат
          в формате: «Минимальная сумма трат за неделю составила … рублей.
           Максимальная сумма трат за неделю составила … рублей».*/

            // 1 вариант

/*
        System.out.println("Минимальная сумма трат за неделю составила " + Arrays.stream(costWeek).min().getAsInt()
                + Ruble(Arrays.stream(costWeek).min().getAsInt()) +".");
        System.out.println("Максимальная сумма трат за неделю составила " + Arrays.stream(costWeek).max().getAsInt()
                + Ruble(Arrays.stream(costWeek).max().getAsInt()) +".");
*/

            // 2 вариант
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < costWeek.length; i++) {
                if (costWeek[i] < minCost) {
                    minCost = costWeek[i];
                }
            }
            System.out.println("Минимальная сумма трат за неделю составила " + Ruble(minCost, "."));

            int maxCost = Integer.MIN_VALUE;
            for (int i = 0; i < costWeek.length; i++) {
                if (costWeek[i] > maxCost) {
                    maxCost = costWeek[i];
                }
            }
            System.out.println("Максимальная сумма трат за неделю составила " + Ruble(maxCost, "."));


            //Задача 3
        /*Теперь бухгалтерия хочет понять, какую в среднем сумму компания тратила еженедельно.
          Создайте массив с пятью целочисленными элементами и задайте каждому элементу значение.
          Напишите программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат
           за месяц поделить на количество недель), и выведите в консоль результат в формате:
           «Средняя сумма трат за месяц составила … рублей».
          Важно помнить: подсчет среднего значения может иметь остаток, то есть быть не целым, а дробным числом.
        */
            double costAverage = (double) costMonth / costWeek.length;
            System.out.println("Средняя сумма трат за месяц составила " + Ruble(costAverage, "."));


            //Задача 4
        /*В бухгалтерской книге появился баг. Что-то пошло не так: фамилии и имена сотрудников начали
        отображаться в обратную сторону. Т. е. вместо «Иванов Иван» мы имеем «навИ вонавИ».
        Данные с именами сотрудников хранятся в виде массива символов  char[ ].
        Напишите код, который развернет содержимое массива, а затем распечатает его содержимое.
        В качестве данных для массива используйте:
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        В результате в консоль должно быть выведено: Ivanov Ivan.
        Важно: не используйте дополнительные массивы для решения этой задачи. Необходимо корректно
         пройти по массиву циклом и поменять его содержимое , чтобы установить правильный порядок.*/


            char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
            char letter;
            for (int i = 0; i < reverseFullName.length / 2; i++) {
                letter = reverseFullName[i];
                reverseFullName[i] = reverseFullName[reverseFullName.length - 1 - i];
                reverseFullName[reverseFullName.length - 1 - i] = letter;
            }
            String fullName = "";
            for (int i = 0; i < reverseFullName.length; i++) {
                fullName += reverseFullName[i];
            }
            System.out.println(fullName);

        }catch (Exception e){
            System.out.println("Введите корректные данные");
        }
    }
    public static String Ruble (int rub,String point){
        String res = "";
        if (rub == 0 ||rub >= 5) {
            res = rub + " рублей";
        } else if (rub == 1) {
            res = rub + " рубль";
        } else if (rub >1 && rub <5) {
            res = rub + " рубля";
        }
        return res + point;
    }
    public static String Ruble (double rub,String point){

        int ruble = (int) rub;
        int kopeika = Integer.parseInt(String.format("%.2f", rub).split("\\,")[1]);
        String res = "";

        if (rub == 0 ||rub >= 5) {
            res =  ruble + " рублей ";
        } else if (ruble == 1) {
            res =  ruble + " рубль ";
        } else if (rub >1 && rub <5) {
            res =  ruble + " рубля ";
        }
        if (kopeika == 0 || kopeika >= 5) {
            res += kopeika + " копеек";
        } else if (kopeika == 1) {
            res += kopeika + " копейка";
        } else if (kopeika >= 2 && kopeika <= 4) {
            res += kopeika + " копейки";
        }
        return res + point;
    }
}
