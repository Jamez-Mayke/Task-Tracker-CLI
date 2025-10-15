import java.io.IOException;

public class TaskTrackerCli {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        if (args.length < 1) {
            System.out.println("Use argumentos para executar o programa");
        }

        String commando = args[0];

        switch (commando) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLIApp add <description>");
                    return;
                }
                taskManager.addTask(args[1]);
                break;
            case "list":
                System.out.println("Listando tasks...");
                System.out.println(taskManager.listTasks());
                break;
            case "update":
                if (args.length < 2) {
                    System.out.println("Uso: TaskTrackerCli update <id> <new description>");
                    break;
                }
                int id = Integer.parseInt(args[1]);
                String newDescription = args[2];
                taskManager.updateTask(id, newDescription);
                break;
            default:
                System.out.println("Comando desconhecido: " + commando);

        }

        taskManager.saveTask();

    }
}