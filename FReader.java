import java.io.FileReader;
import java.io.IOException;
/**
 * Посимвольно читает из файла
 */
public class FReader implements IStreamIn{
    private FileReader reader;

    /**
     * Конструктор
     * @param name - имя файла с исходным кодом
     */
    public FReader(String name) throws IOException {
        this.reader = new FileReader(name);

    }

    /**
     * Закрывает файл
     */
    @Override
    public void close() throws IOException {
        reader.close();

    }

    /**
     * Возвращает один символ из файла
     */
    @Override
    public char getSymbol() throws IOException {
        return (char)reader.read();
    }

    /**
     * Проверяет достигнут ли конец файла
     */
    public boolean ready() throws IOException {
        return reader.ready();
    }
}

