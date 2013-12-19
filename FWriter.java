import java.io.FileWriter;
import java.io.IOException;
/**
 * Производит посимволную запись в файл
 */
public class FWriter implements IStreamOut {
    private FileWriter writer;
    private String nameFile;

    /**
     * Конструктор
     * @param name - имя файла для записи
     */
    public FWriter(String name) throws IOException {
        writer = new FileWriter(name);
        this.nameFile = name;
    }

    /**
     * Записывает полученный символ в файл
     * @param data - символ для записи в файл
     */
    @Override
    public void writeSymbol(char data) throws IOException {
        writer.write(data);
    }

    /**
     * Записывает в файл перевод строки
     */
    @Override
    public void writeNewLine() throws IOException {
        writer.write("\r");
        writer.write("\n");
    }

    /**
     * Закрывает файл
     */
    @Override
    public void close() throws IOException {
        writer.close();
    }

    /**
     * Возвращает имя файла, в который осуществляется запись
     */
    @Override
    public String getSourse() {
        return "Результат работы программы: \r\n" +nameFile;
    }
}
