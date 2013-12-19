import java.io.IOException;
/**
 * Входной поток символов
 */
public interface IStreamIn {
    char getSymbol () throws IOException;
    void close() throws IOException;
    boolean ready() throws IOException;
}
