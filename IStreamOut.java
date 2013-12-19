import java.io.IOException;
/**
 * Выходной поток символов
 */
public interface IStreamOut {
    void writeSymbol(char data) throws IOException;
    void writeNewLine() throws IOException;
    void close() throws IOException;
    String getSourse();

}
