import java.time.LocalDateTime;
import java.util.Arrays;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String toJson() {
        return "{\"" + "id\":\"" + id + "\", " + "\"description\":\"" + description + "\", " + "\"status\":\"" + status +
                "\", " + "\"createdAt\":\"" + createdAt + "\", " + "\"updatedAt\":\"" + updatedAt + "\"}";
    }

    public static Task fromJson(String json) {
        json = json
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "");
        String[] json1 = json.split(",");

        String id = json1[0].split(":")[1].strip();
        String description = json1[1].split(":")[1].strip();
        String status = json1[2].split(":")[1].strip();
        String createdAt = json1[3].split("[a-z]:")[1].strip();
        String updatedAt = json1[4].split("[a-z]:")[1].strip();

        Status statusFormated = Status.valueOf(status.toUpperCase().replace(" ", "_"));

        Task task = new Task(description);
        task.id = Integer.parseInt(id);
        task.status = statusFormated;
        task.createdAt = LocalDateTime.parse(createdAt);
        task.updatedAt = LocalDateTime.parse(updatedAt);

        if(Integer.parseInt(id) > lastId) {
            lastId = Integer.parseInt(id);
        }

        return task;
    }

    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "id" + " : " + id +
                ", description" + " : " + description +
                ", status" + " : " + status +
                ", createdAt" + " : " + createdAt +
                ", updatedAt" + " : " + updatedAt +
                '}';
    }
}
