import java.util.Scanner;

class Student {
    String name;
    String regNo;
    String room;
    int seatNo;

    Student(String name, String regNo,
            String room, int seatNo) {
        this.name = name;
        this.regNo = regNo;
        this.room = room;
        this.seatNo = seatNo;
    }

    void display() {
        System.out.println(name + "\t" + regNo
                + "\t" + room + "\t" + seatNo);
    }
}

public class ExamSeatAllotment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter room number: ");
        String room = sc.nextLine();

        System.out.print("Enter seats available: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (n <= 0 || capacity <= 0) {
            System.out.println("Invalid input!");
            sc.close();
            return;
        }

        if (n > capacity) {
            System.out.println(
                "Not enough seats in this room!");
            sc.close();
            return;
        }

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println(
                "\nEnter details of student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Register number: ");
            String regNo = sc.nextLine();

            students[i] = new Student(
                name, regNo, room, i + 1);
        }

        System.out.println("\n--- SEAT ALLOTMENT ---");
        System.out.println(
            "Name\tRegister No\tRoom\tSeat");

        for (Student s : students) {
            s.display();
        }

        System.out.print(
            "\nEnter register number to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s.regNo.equalsIgnoreCase(search)) {
                System.out.println("Seat details:");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }

        sc.close();
    }
}