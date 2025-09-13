package org.example;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
            // 🔹 Пример 1. Конструктор с параметрами
            Client client1 = new Client(
                    "ООО Ромашка",
                    "Частная",
                    "Москва, ул. Ленина, д. 10",
                    "89991234567",
                    "Иванов Иван"
            );

            String jsonFilePath = "C:/Users/user/Desktop/client.json";
            Client client2 = new Client(jsonFilePath, true);

            String dataString = "ООО_Лилия Частная Санкт-Петербург 8123456789 Петров_Петр";
            Client client3 = new Client(dataString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
