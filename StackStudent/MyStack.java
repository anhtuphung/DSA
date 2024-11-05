package StackStudent;

public class MyStack {
    Student[] students;
    int top, max;

    public MyStack(int max) {
        this.max = max;
        students = new Student[max];
        top = -1;
    }

    public boolean IsEmpty() {
        return top == -1;
    }

    public boolean IsFull() {
        return top == max - 1;
    }

    public void push(Student student) {
        if (IsFull()) {
            System.out.println("Stack is full");
        } else {
            students[++top] = student;
        }
    }

    public Student pop() {
        if (IsEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return students[top--];
        }
    }

    public Student top() {
        if (IsEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return students[top];
        }
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            students[i].printStudent();
        }
    }

    public void sortByMarks() {
        for (int i = 0; i < top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (students[i].marks < students[j].marks) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public void searchByName(String name) {
        for (int i = 0; i <= top; i++) {
            if (students[i].name.equalsIgnoreCase(name)) {
                students[i].printStudent();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudentById(int id) {
        boolean found = false;
        int index = -1;
        for (int i = 0; i <= top; i++) {
            if (students[i].id == id) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            // Shift elements to "delete" the student
            for (int i = index; i < top; i++) {
                students[i] = students[i + 1];
            }
            students[top] = null;  // Clear the last position
            top--;  // Reduce the stack size
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void editStudentById(int id, String newName, double newMarks) {
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (students[i].id == id) {
                students[i].name = newName;
                students[i].marks = newMarks;
                System.out.println("Student information updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

}
