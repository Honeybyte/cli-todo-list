import java.util.ArrayList;
import java.util.Scanner;

class Lists {
    static ArrayList<Todo> todos = new ArrayList<Todo>();

    public static void main(String[] args) {
        render();
    }

    static void render() {
        System.out.println("Welcome my Todo-list application");
        System.out.println("========================================================");
        System.out.println("Id\t\t\t|\tTitle\t|\tCompleted");
        System.out.println("========================================================");
        todos.stream().forEach(todo -> {
            System.out.println(todo.id + "\t|\t" + todo.text + "\t|\t" + todo.completed);
            System.out.println("--------------------------------------------------------");
        });

        System.out.println("\n\n+++++++++++++++ CREATE NEW TODO +++++++++++++++++++++++++");
        System.out.println("\n Enter todo title");

        try (Scanner in = new Scanner(System.in)) {
            String todoTitle = in.nextLine();
            todos.add(new Todo(todoTitle));

            System.out.print("\033[H\033[2J");
            System.out.flush();

            render();
        }
    }

    static class Todo {
        private final String text;
        private final double id = Math.random();
        private final boolean completed = false;

        Todo(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "Todo { \ntext='" + text + "',\ncompleted='" + completed + "',\nid='" + id + "'";
        }

    }
}