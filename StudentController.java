package BTGK;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class StudentController {
    private List<Student> students = new ArrayList<>();                                                                                                                      //Đây là một danh sách riêng tư kiểu List<Student> được khởi tạo với ArrayList<>. Nó sẽ lưu trữ các đối tượng Student được thêm vào StudentController.
    private File file = new File("students.txt");                                                                                                                     //Khởi tạo một đối tượng File biểu diễn file "students.txt" trong thư mục hiện tại.
    public void addStudent(String name, int age) {
        students.add(new Student(name, age));
    }

    public void saveStudentsToFile() {                                                                                                                                                 // Phương thức công khai saveStudentsToFile dùng để lưu danh sách sinh viên vào file "students.txt".
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {                                                                                                                           //PrintWriter writer = new PrintWriter(new FileWriter(file)): Tạo một đối tượng PrintWriter để ghi dữ liệu vào file "students.txt".
            students.forEach(student -> writer.println(student.getName() + "," + student.getAge()));                                                                                                                      //Duyệt qua từng sinh viên trong danh sách students bằng forEach.
                                                                                                                                                                                                                                                      //Bên trong vòng lặp, lấy tên và tuổi của sinh viên (student.getName() và student.getAge()).
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudentsFromFile() {                                                                                                                                                 // Phương thức công khai loadStudentsFromFile dùng để đọc danh sách sinh viên từ file "students.txt".
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {                                                                                                                      //BufferedReader reader = new BufferedReader(new FileReader(file)): Tạo một đối tượng BufferedReader để đọc dữ liệu từ file "students.txt".
            students = reader.lines()                                                                                                                                                   //Sử dụng students = reader.lines() để đọc từng dòng của file thành một luồng stream các chuỗi.
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new Student(parts[0], Integer.parseInt(parts[1]));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayStudents() {
        students.forEach(student -> System.out.println("Name: " + student.getName() + ", Age: " + student.getAge()));
    }
}
