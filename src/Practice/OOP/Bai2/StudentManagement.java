package Practice.OOP.Bai2;

import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> studentList;
    private ReadAndWriteFile readAndWriteFile;

    public StudentManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        this.studentList = readAndWriteFile.readStudentFile();
    }

    public void addStudent(Student newStudent) {
        studentList.add(newStudent);
        readAndWriteFile.writeStudenFile(studentList);
    }

    public void showAll() {
        System.out.println("---------------------- Danh sách học sinh ----------------------");
        if(studentList.isEmpty()){
            System.out.println("Chưa có học sinh nào cả!.");
        } else {
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
        }
        System.out.println("------------------------------------------------------------------");
    }

    public Student findStudentById(int id) {
        for (Student student : studentList) {
            if(student.getIdStudent() == id) {
                return student;
            }
        }
        return null;
    }
}
