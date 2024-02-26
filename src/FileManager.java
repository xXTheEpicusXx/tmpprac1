import java.io.*;

public class FileManager {
    public void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + filePath);
            } else {
                System.out.println("Файл уже существует: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    // Метод для удаления файла
    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Файл удален: " + filePath);
            } else {
                System.out.println("Не удалось удалить файл: " + filePath);
            }
        } else {
            System.out.println("Файл не найден: " + filePath);
        }
    }

    // Метод для переименования файла
    public void renameFile(String oldFilePath, String newFilePath) {
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);
        if (oldFile.exists()) {
            if (oldFile.renameTo(newFile)) {
                System.out.println("Файл переименован из " + oldFilePath + " в " + newFilePath);
            } else {
                System.out.println("Не удалось переименовать файл: " + oldFilePath);
            }
        } else {
            System.out.println("Файл не найден: " + oldFilePath);
        }
    }

    // Метод для чтения данных из файла
    public String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return content.toString();
    }

    // Метод для записи данных в файл
    public void writeFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Данные успешно записаны в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}
