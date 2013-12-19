import java.io.IOException;
/**
 * Форматирует исходный текст на Java.
 * Расставляет фигурные скобоки и отступы в управляющих конструкциях, осуществляет перевод строки после ';'.
 * Особые условия: в форматируемом коде нет комментариев и строковых констант.
 */
public class Formatter {
    private IStreamIn reader ;
    private IStreamOut writer ;
    private int parenthesis = 0;
    private int openBrace = 0;
    private int indent = 4;
    private boolean newLine = false;
    private boolean space = false;

    /**
     * Конструктор при работе с файлом
     * @param input - файл с исходным кодом для форматирования
     * @param output - файл с результатом форматирования
     */
    public Formatter (String input, String output) throws IOException {
        reader = new FReader(input);
        writer = new FWriter(output);
    }

    /**
     * Конструктор при работе со строчкой
     * @param input - строчка с исходным текстом для форматирования
     */
    public Formatter (String input) throws IOException {
        reader = new StrReader(input);
        writer = new StrWriter();
    }

    /**
     * Форматирование исходного кода
     */
    public void format() throws IOException {
        while (reader.ready()) {
            char data = reader.getSymbol();
            switch (data) {
                case ';':
                    if (parenthesis != 0) writer.writeSymbol(data);
                    else {
                        writer.writeSymbol(data);
                        writer.writeNewLine();
                        newLine = true;
                        space = false;
                    }
                    break;
                case '{':
                    openBrace++;
                    writer.writeSymbol(data);
                    writer.writeNewLine();
                    newLine = true;
                    space = false;
                    break;
                case '(':
                    parenthesis++;
                    writer.writeSymbol(data);
                    newLine = false;
                    space = false;
                    break;
                case '}':
                    openBrace--;
                    for ( int i = 0; i < indent*openBrace; i++ ){
                        writer.writeSymbol(' ');
                    }
                    writer.writeSymbol(data);
                    writer.writeNewLine();
                    newLine = true;
                    space = false;
                    break;
                case ')':
                    parenthesis--;
                    writer.writeSymbol(data);
                    newLine = false;
                    space = false;
                    break;
                case ' ':
                    if ((!space)&&(!newLine)){
                        writer.writeSymbol(data);
                    }
                    space = true;
                    break;
                case '\t':
                    space = false;
                    break;
                case '\r':
                    //Пробрасываем входящий перевод строки
                    /*if (!newLine){
                        writer.write(data);
                    }*/
                    space = false;
                    break;
                case '\n':
                    //Пробрасываем входящий перевод строки
                    /*if (!newLine){
                        writer.write(data);
                    }*/
                    space = false;
                    break;
                default:
                    if (newLine){
                        for ( int i = 0; i < indent*openBrace; i++ ){
                            writer.writeSymbol(' ');
                        }

                    }
                    space = false;
                    newLine = false;
                    writer.writeSymbol(data);
            }

        }
        System.out.println(writer.getSourse());
        reader.close();
        writer.close();
    }
}
