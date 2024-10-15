package Practice.OOP.Bai2;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class RegisterSubjectManagement {
    private static List<RegisterSubject> registerSubjectList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        StudentManagement studentManagement = new StudentManagement();
        SubjectManagement subjectManagement = new SubjectManagement();

//        Student student1 = new Student("Phạm Thu Ngân", "Bồng Sơn", "0123", "C01");
//        Student student2 = new Student("Dương Văn Nhật", "Ân Hảo Đông", "0124", "C02");
//        Student student3 = new Student("Phạm Minh Phú", "Năng An", "0125", "C01");
//        Student student4 = new Student("Lê Hoàng Khôi", "Tăng Bạt Hổ", "0128", "C03");
//
//        Subject subject1 = new Subject("CSDL", 6, SubjectType.CHUYEN_NGANH_BAT_BUOC);
//        Subject subject2 = new Subject("Triết Mác-Lênin", 5, SubjectType.DAI_CUONG);
//        Subject subject3 = new Subject("Nguyên lí HĐH", 4, SubjectType.CHUYEN_NGANH_TU_CHON);
//        Subject subject4 = new Subject("Lập trình hướng đối tượng", 8, SubjectType.CHUYEN_NGANH_BAT_BUOC);
//        Subject subject5 = new Subject("Giải tích 1", 6, SubjectType.CHUYEN_NGANH_TU_CHON);
//        Subject subject6 = new Subject("Tiếng anh cơ bản 2", 6, SubjectType.CO_SO_NGANH);
//        Subject subject7 = new Subject("Phát triển kỹ năng 2", 4, SubjectType.DAI_CUONG);
//
//        Map<Subject, LocalDateTime> list1 = new HashMap<>();
//        list1.put(subject1, LocalDateTime.now());
//        list1.put(subject2, LocalDateTime.now());
//        list1.put(subject4, LocalDateTime.now());
//        list1.put(subject6, LocalDateTime.now());
//        RegisterSubject registerSubject1 = new RegisterSubject(student1);
//        registerSubject1.registerSubject(list1);
//        registerSubject1.saveToFile();
//
//        Map<Subject, LocalDateTime> list2 = new HashMap<>();
//        list2.put(subject2, LocalDateTime.now());
//        list2.put(subject3, LocalDateTime.now());
//        list2.put(subject5, LocalDateTime.now());
//        RegisterSubject registerSubject2 = new RegisterSubject(student2);
//        registerSubject2.registerSubject(list2);
//        registerSubject2.saveToFile();
//
//        Map<Subject, LocalDateTime> list3 = new HashMap<>();
//        list3.put(subject5, LocalDateTime.now());
//        list3.put(subject7, LocalDateTime.now());
//        RegisterSubject registerSubject3 = new RegisterSubject(student3);
//        registerSubject3.registerSubject(list3);
//        registerSubject3.saveToFile();
//
//        Map<Subject, LocalDateTime> list4 = new HashMap<>();
//        list4.put(subject1, LocalDateTime.now());
//        list4.put(subject5, LocalDateTime.now());
//        RegisterSubject registerSubject4 = new RegisterSubject(student4);
//        registerSubject4.registerSubject(list4);
//        registerSubject4.saveToFile();

        int chooseOption;
        do{
            System.out.println("1.Danh sách sinh viên.");
            System.out.println("2.Thêm sinh viên.");
            System.out.println("3.Danh sách môn học.");
            System.out.println("4.Thêm môn học.");
            System.out.println("5.Đăng ký môn học cho sinh viên.");
            System.out.println("0.Thoát.");
            chooseOption = scanner.nextInt();
            switch (chooseOption) {
                case 1:
                    studentManagement.showAll();
                    break;
                case 2:
                    addNewStudent(studentManagement);
                    break;
                case 3:
                    subjectManagement.showAll();
                    break;
                case 4:
                    addNewSubject(subjectManagement);
                    break;
                case 5:
                    registerSubjectForStudent(studentManagement, subjectManagement);
                    break;
            }
        }while (chooseOption != 0);
    }

    private static void registerSubjectForStudent(StudentManagement studentManagement, SubjectManagement subjectManagement) {
        System.out.println("Nhập mã sinh viên:");
        int studentId = scanner.nextInt();
        Student student = studentManagement.findStudentById(studentId);
        if (student == null) {
            System.out.println("---------------- Sinh viên không tồn tại! ----------------");
            return;
        }
        System.out.println("Sinh viên có id mà bạn đã nhập là: " + student);
        RegisterSubject registerSubject = new RegisterSubject(student);

        Map<Subject, LocalDateTime> listSubject = new HashMap<>();
        System.out.println("Nhập mã môn học (nhập 0 để dừng):");
        while (true) {
            int subjectId = scanner.nextInt();
            if (subjectId == 0) break;
            Subject subject = subjectManagement.findSubjectById(subjectId);
            if (subject != null) {
                listSubject.put(subject, LocalDateTime.now());
                System.out.println("Bạn vừa đăng ký môn: " + subject);
                System.out.println("Nhập tiếp id của môn học nếu bạn muốn đăng kí tiếp hoặc nhập 0 để dừng: ");
            } else {
                System.out.println("---------------- Môn học không tồn tại! ----------------");
            }
        }
        registerSubject.registerSubject(listSubject);
        registerSubject.saveToFile();

        registerSubjectList.add(registerSubject);
        System.out.println("Đăng ký các môn học thành công cho sinh viên: " + student.getFullName());
    }


    private static void addNewSubject(SubjectManagement subjectManagement) {
        System.out.println("Nhập tên môn học:");
        scanner.nextLine();
        String nameSubject = scanner.nextLine();
        System.out.println("Nhập số tín chỉ:");
        int totalLesson = scanner.nextInt();
        System.out.println("Nhập loại môn học (0: ĐẠI CƯƠNG, 1: CƠ SỞ NGÀNH, 2: CHUYÊN NGÀNH BẮT BUỘC, 3: CHUYÊN NGÀNH TỰ CHỌN) :");
        int subjectTypeChoice = scanner.nextInt();
        SubjectType subjectType = SubjectType.values()[subjectTypeChoice];
        Subject newSubject = new Subject(nameSubject, totalLesson, subjectType);
        subjectManagement.addSubject(newSubject);
        System.out.println("----------------- Thêm môn học mới thành công! -----------------");
    }

    private static void addNewStudent(StudentManagement studentManagement) {
        System.out.println("Nhập tên học sinh:");
        scanner.nextLine();
        String nameStudent = scanner.nextLine();
        System.out.println("Nhập địa chỉ:");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại:");
        String phone = scanner.nextLine();
        System.out.println("Nhập lớp học:");
        String classroom = scanner.nextLine();
        Student newStudent = new Student(nameStudent, address, phone, classroom);
        studentManagement.addStudent(newStudent);
        System.out.println("----------------- Thêm học sinh mới thành công! -----------------");
    }
}
