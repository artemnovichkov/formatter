import java.io.IOException;
/**
 * Производит посимвольную запись в строку
 */
public class StrWriter implements IStreamOut {
    private String stSourse;

    /**
     * Конструктор
     */
    public StrWriter(){
        this.stSourse="";
    }

    /**
     * Записывает полученный символ в строку
     * @param data - символ для записи
     */
    @Override
    public void writeSymbol(char data) throws IOException {
        stSourse = stSourse +data;
        //System.out.println(stSourse);
    }

    /**
     * Записывает в файл перевод строки
     */
    @Override
    public void writeNewLine() throws IOException {
        stSourse = stSourse +"\r\n";
        //System.out.println(stSourse);
    }


    @Override
    public void close() throws IOException {

    }

    /**
     * Возвращает строку с результатом форматирования
     */
    public String getSourse(){
        return stSourse;
    }
}
