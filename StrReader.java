import java.io.IOException;
/**
 * Посимвольно читает из строчки
 */
public class StrReader implements IStreamIn{
    private char[] chSourse;
    int length = 0;
    int position = 0;

    /**
     * Конструктор
     * @param stSource - строчка с исходным кодом для форматирования
     */
    public StrReader (String stSource){
        this.chSourse = stSource.toCharArray();
        this.length = stSource.length();
        this.position = 0;

    }

    /**
     * Возвращает один символ из строки
     */
    @Override
    public char getSymbol() throws IOException {
        char simbol = chSourse[position];
        this.position++;
        return simbol;
    }

    @Override
    public void close() throws IOException {

    }

    /**
     * Проверяет достигнут ли конец строки
     */
    @Override
    public boolean ready() throws IOException {
        return ((length>position)&&(length!=0));
    }
}
