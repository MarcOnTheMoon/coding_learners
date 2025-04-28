package sandbox;

public class Student {
    String name;

    Student() {
        this("<Name");
        System.out.println("Verlasse Student() ...");
    }

    Student(String name) {
        setName(name);
        System.out.println("Verlasse Student(String) ...");
    }

    void setName(String name) {
        this.name = name;
    }
}
