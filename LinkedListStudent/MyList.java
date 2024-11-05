package LinkedListStudent;

public class MyList {
    Node head;

    public MyList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            temp.student.printStudent();
            temp = temp.next;
        }
    }

    public void deleteStudentById(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.student.id == id) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.student.id != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    public void editStudentById(int id, String newName, double newMarks) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.id == id) {
                temp.student.name = newName;
                temp.student.marks = newMarks;
                System.out.println("Student information updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void sortByMarks() {
        if (head == null) return;
        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.student.marks < j.student.marks) {
                    Student temp = i.student;
                    i.student = j.student;
                    j.student = temp;
                }
            }
        }
    }

    public void searchByName(String name) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.student.name.equalsIgnoreCase(name)) {
                temp.student.printStudent();
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
