import java.util.LinkedList;
import java.util.Queue;

// Класс для представления задачи
class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

// Класс для планирования и выполнения задач
public class TaskScheduler {
    private Queue<Task> taskQueue;

    public TaskScheduler() {
        this.taskQueue = new LinkedList<>();
    }

    // Метод для добавления новой задачи в очередь
    public void addTask(Task task) {
        taskQueue.offer(task);
        System.out.println("Добавлена новая задача: " + task.getDescription());
    }

    // Метод для выполнения следующей задачи в очереди
    public void executeNextTask() {
        if (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Выполнена задача: " + task.getDescription());
        } else {
            System.out.println("Очередь задач пуста.");
        }
    }
}