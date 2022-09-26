import java.util.Arrays;
public class Main {
    /**
     * Дан символ C. Вывести два символа, первый из которых предшествует символу C в кодовой таблице,
     * а второй следует за символом C
     **/
    private static void task1() {
        char C = '8';
        System.out.printf("Previous: %c, following: %c", C - 1, C + 1);
    }

    /**
     * Дано целое число N (> 0) и строка S. Преобразовать строку S в строку длины N следующим образом:
     * если длина строки S больше N,
     * то отбросить первые символы, если длина строки S меньше N, то в ее начало добавить символы «.» (точка).
     **/
    private static void task2() {
        int N = 6;
        String str1 = "Hello! I am cat.";
        int length = str1.length();
        if (length > N) str1 = str1.substring(length - N);
        else {
            String[] sub = new String[length - N];
            Arrays.fill(sub, '.');
            str1 = sub + str1;
        }
        System.out.printf("New string: %s", str1);
    }

    /**
     * Дана строка, состоящая из слов кириллицей, набранных заглавными буквами и разделенных пробелами (одним или несколькими).
     * Преобразовать каждое слово в строке, заменив в нем все предыдущие вхождения его последней буквы на символ «.» (точка).
     * Например, слово «МИНИМУМ» надо преобразовать в «.ИНИ.УМ». Количество пробелов между словами не изменять.
     **/
    private static void task3() {
        String str = "МИНИМУМ МАКСИМУМ МИНИМУМ";
        String[] subs = str.split(" ");
        for (int i = 0; i < subs.length; i++) {
            char[] temp_arr = subs[i].toCharArray();
            char last = temp_arr[temp_arr.length - 1];
            for (int j = 0; j < temp_arr.length - 1; j++) {
                if (temp_arr[j] == last) {
                    temp_arr[j] = '.';
                }
            }
            subs[i] = String.copyValueOf(temp_arr);
        }
        System.out.println(String.join(" ", subs));
    }

    /**
     * Дана строка, содержащая полное имя файла. Выделить из этой строки название первого каталога (без символов «/»).
     * Если файл содержится в корневом каталоге, то вывести символ «/».
     **/
    private static void task4() {
        String filename = "D:/work/test.docx";
        String[] sub_file = filename.split("/");
        if (sub_file.length == 2) {
            System.out.println('/');
        } else {
            System.out.println(sub_file[1]);
        }
    }

    /**
     * Дана строка-предложение. Зашифровать ее, поместив вначале все символы, расположенные
     * на четных позициях строки, а затем, в обратном порядке, все символы,
     * расположенные на нечетных позициях (например, строка «Программа» превратится в «ргамамроП»).
     **/
    private static void task5_1() {
        String str = "Кот и кошка смотрят из окошка";
        char[] temp_arr = str.toCharArray();
        char[] temp_arr2 = new char[temp_arr.length];
        for (int i = 0; i < temp_arr.length / 2; i++) {
            temp_arr2[i] = temp_arr[2 * i + 1];
            temp_arr2[temp_arr.length - (i + 1)] = temp_arr[2 * i];
        }
        if (temp_arr.length % 2 != 0) {
            temp_arr2[temp_arr.length / 2] = temp_arr[temp_arr.length - 1];
        }
        String res = String.copyValueOf(temp_arr2);
        System.out.println(res);
    }

    /**
     * Дано предложение, зашифрованное по правилу, описанному в задании 66. Расшифровать это предложени
     **/
    private static void task5() {
        String str = "о  ок мтя зоокашк итросашкитК";
        char[] temp_arr = str.toCharArray();
        char[] temp_arr2 = new char[temp_arr.length];
        for (int i = 0; i < temp_arr.length / 2; i++) {
            temp_arr2[2 * i + 1] = temp_arr[i];
            temp_arr2[2 * i] = temp_arr[temp_arr.length - (i + 1)];
        }
        if (temp_arr.length % 2 != 0) {
            temp_arr2[temp_arr.length - 1] = temp_arr[temp_arr.length / 2];
        }
        String res = String.copyValueOf(temp_arr2);
        System.out.println(res);
    }

    /**
     * Дана строка, содержащая латинские буквы и скобки трех видов: «()», «[]», «{}».
     * Если скобки расставлены правильно (т. е. каждой открывающей соответствует закрывающая скобка того же вида),
     * то вывести число 0. В противном случае вывести или номер позиции,
     * в которой расположена первая ошибочная скобка, или, если закрывающих скобок не хватает, число −1.
     **/
    public static void task6() {
         String str = "Rain { movie}  calls  (Rain) Movie I like it [so]";
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int error_index = 0;
        for (var c: str.toCharArray()) {
            if (c == '{') {
                n1--;
            }
            if (c == '}') {
                n1++;
            }
            if (c == '[') {
                n2--;
            }
            if (c == ']') {
                n2++;
            }
            if (c == '(') {
                n3--;
            }
            if (c == ')') {
                n3++;
            }
            if ((n1 > 0 || n2 > 0 || n3 > 0) ) {
                error_index = str.indexOf(c);
                System.out.println("First error position is " + error_index);
            }
        }
        if (n1 == 0 && n2 == 0 && n3 == 0) {
            System.out.println("0");
        }
        if (n1 < 0 || n2 < 0 || n3 < 0) {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        System.out.print("\n Task 1 \n");
        task1();
        System.out.print("\n Task 2 \n");
        task2();
        System.out.print("\n Task 3 \n");
        task3();
        System.out.print("\n Task 4 \n");
        task4();
        System.out.print("\n Task 5_1 \n");
        task5_1();
        System.out.print("\n Task 5 \n");
        task5();
        System.out.print("\n Task 6 \n");
        task6();
    }
}
