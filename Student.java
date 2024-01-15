public class Student {
    private final int id = counter++;
    private static int counter = 1;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Student.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
