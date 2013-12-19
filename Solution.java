import java.io.*;
/**
 * Точка входа
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Formatter formatter;
        // Если параметр file - ввод/вывод осуществляется в файлы
        if (args[0]=="file"){
            //String input = args[0];
            //String output = args[1];
            String input = "C:\\Formatter\\code.txt";
            String output = "C:\\Formatter\\newcode.txt";
            formatter = new Formatter(input,output);
        }else{
            //В остальных случаях работаем со строчкой
            String input = "public void InsertionSort( int[] data, int firstElement, int lastElement ) {\n" +
                    "    int lowerBoundary = data\n" +
                    "[ firstElement\u000E1 ];\n" +
                    "    data[ firstElement\u000E1 ] = SORT_MIN;\n" +
                    "    for ( int sortBoundary =\n" +
                    "firstElement+1; sortBoundary <= lastElement; sortBoundary++ ) {\n" +
                    "        int insertVal =\n" +
                    "data[ sortBoundary ];\n" +
                    "        int insertPos = sortBoundary;\n" +
                    "        while ( insertVal < data[\n" +
                    "insertPos -\u000E1 ] ) {\n" +
                    "            data[ insertPos ] = data[ insertPos -\u000E1 ];\n" +
                    "            insertPos = insertPos\u000E1;\n" +
                    "            }\n" +
                    "        data[ insertPos ] = insertVal;\n" +
                    "        }\n" +
                    "    data[ firstElement -\u000E1 ] = lowerBoundary;\n" +
                    "    }";
            formatter = new Formatter(input);
        }
        formatter.format();
    }
}
