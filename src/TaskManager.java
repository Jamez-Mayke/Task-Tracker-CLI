import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final Path FILE_PATH = Path.of("tasks.json");
    private final List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    public List<Task> loadTasks() {
        List<Task> storedTask = new ArrayList<>();

        if (!Files.exists(FILE_PATH)) {
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskList = jsonContent
                    .replace("[", "")
                    .replace("]", "")
                    .split("},");

            for (String taskJson : taskList) {
                if (!taskJson.endsWith("}")) {
                    taskJson = taskJson + "}";
                    storedTask.add(Task.fromJson(taskJson));
                } else {
                    storedTask.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return storedTask;

    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
    }

    public void saveTask() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\n");
        for (int i = 0; i < tasks.size(); i++) {
            stringBuilder.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1) {
                stringBuilder.append(",\n");
            }
        }
        stringBuilder.append("\n]");

        String jsonContent = stringBuilder.toString();
        try {
            Files.writeString(FILE_PATH, jsonContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Task> listTasks() {
        return tasks;
    }
}
