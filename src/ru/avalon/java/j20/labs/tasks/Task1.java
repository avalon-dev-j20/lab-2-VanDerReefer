package ru.avalon.java.j20.labs.tasks;

import java.io.ByteArrayOutputStream;
import ru.avalon.java.j20.labs.Task;
import java.io.*;


/**
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("countries_binary_mode_output.txt");
        String text = read(input);
        write(output, text);

        /*
         * TODO(Студент): Выполнить задание №1
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    InputStream и FileInputStream.
         *
         *    Для сохранениня прочитанных данных следует пользоваться
         *    классом ByteArrayOutputStream.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    OutputStream и FileOutputStream.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение указанного файла в двоичном режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        if (file == null) throw new NullPointerException("There is no file.");

        try (ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
             InputStream fis = new FileInputStream(file);) {
            byte[] buf = new byte[70000];
            while (true) {
                int readBytesCount = fis.read(buf);
                if (readBytesCount == -1) {
                    break;
                }
                if (readBytesCount > 0) {
                    arrayOutputStream.write(buf, 0, readBytesCount);
                }
            }
            arrayOutputStream.write(buf);
            return arrayOutputStream.toString();
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        OutputStream fos = new FileOutputStream(file);
        byte[] buffer = text.getBytes();
        fos.write(text.getBytes(), 0, buffer.length);
    }
}
