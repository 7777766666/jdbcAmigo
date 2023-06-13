package com.amigoscode.sobes;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFConverter {
    public static void main(String[] args) {
        try {
            // Открываем PDF-файл
            PDDocument document = PDDocument.load(new File("путь_к_вашему_файлу.pdf"));

            // Создаем экземпляр объекта PDFTextStripper
            PDFTextStripper textStripper = new PDFTextStripper();

            // Извлекаем текст из PDF-файла
            String text = textStripper.getText(document);

            // Выводим извлеченный текст
            System.out.println(text);

            // Закрываем документ
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


