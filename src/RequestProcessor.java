import java.util.LinkedList;
import java.util.Queue;

// Класс для обработки заявок
public class RequestProcessor {

    private Queue<Request> requestQueue;

    public RequestProcessor() {
        this.requestQueue = new LinkedList<>();
    }

    // Метод для добавления новой заявки в очередь
    public void addRequest(Request request) {
        requestQueue.offer(request);
        System.out.println("Добавлена новая заявка: " + request.getContent());
    }

    // Метод для обработки заявок в порядке очереди
    public void processRequests() {
        while (!requestQueue.isEmpty()) {
            Request request = requestQueue.poll();
            System.out.println("Обработана заявка: " + request.getContent() + "\nРезультат:" + (Math.round(Math.random()*1) == 1 ? "Принято" : "Отклонено"));
        }
        System.out.println("Очередь заявок пуста.");
    }



}

//Вспомогательный класс заявки
class Request {
    private String content;

    public Request(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}