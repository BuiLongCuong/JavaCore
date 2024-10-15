package Practice.OOP.Bai2;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWriteFile {
    File studentFile = new File("dataLessons/Lesson2/Students.csv");
    File subjectFile = new File("dataLessons/Lesson2/Subjects.csv");
    File registerSubjectFile = new File("dataLessons/Lesson2/RegisterSubjects.csv");

    public void writeStudenFile(ArrayList<Student> list) {
        try {
            FileWriter fileWriter = new FileWriter(studentFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Student student : list) {
                line += student.getIdStudent() + "," + student.getFullName() + "," + student.getAddress() + "," + student.getPhoneNumber() + "," + student.getClassroom() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Student> readStudentFile() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(studentFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataStudent = line.split(",");
                Student student = new Student(dataStudent[1], dataStudent[2], dataStudent[3], dataStudent[4]);
                list.add(student);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeSubjectFile(ArrayList<Subject> list) {
        try {
            FileWriter fileWriter = new FileWriter(subjectFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Subject subject : list) {
                line += subject.getIdSubject() + "," + subject.getNameSubject() + "," + subject.getTotalOfLessons() + "," + subject.getSubjectType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Subject> readSubjectFile() {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(subjectFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataSubject = line.split(",");
                SubjectType subjectType = Enum.valueOf(SubjectType.class, dataSubject[3].trim().toUpperCase());
                Subject subject = new Subject(dataSubject[1], Integer.parseInt(dataSubject[2]), subjectType);
                list.add(subject);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeRegisterSubjectFile(RegisterSubject registerSubject) {
        try {
            FileWriter fileWriter = new FileWriter(registerSubjectFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String infoStudent = "";
            Student student = registerSubject.getStudent();
            bufferedWriter.write("Thông tin học sinh: \n");
            infoStudent += "ID: " + student.getIdStudent() + "," + student.getFullName() + "," + student.getAddress() + "," +
                    student.getPhoneNumber() + "," + student.getClassroom() + "\n";
            bufferedWriter.write(infoStudent);

            bufferedWriter.write("Danh sách đăng kí môn học: \n");
            for (Map.Entry<Subject, LocalDateTime> entry : registerSubject.getSubjectWithTime().entrySet()) {
                Subject subject = entry.getKey();
                LocalDateTime localDateTime = entry.getValue();
                String infoSubject = "ID: " + subject.getIdSubject() + "," + subject.getNameSubject() + "," +
                        subject.getTotalOfLessons() + "," + subject.getSubjectType() + "," +
                        " đăng kí lúc " + localDateTime + "\n";
                bufferedWriter.write(infoSubject);
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public RegisterSubject readRegisterSubjectFile() {
        RegisterSubject registerSubject = null;
        Map<Subject, LocalDateTime> listSubject = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(registerSubjectFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            if ((line = bufferedReader.readLine()) != null && !line.equals("Thông tin học sinh: ")) {
                String[] dataStudent = line.split(",");
                Student student = new Student(dataStudent[1], dataStudent[2], dataStudent[3], dataStudent[4]);
                registerSubject = new RegisterSubject(student);
            }

            while ((line = bufferedReader.readLine()) != null && line.equals("Danh sách đăng kí môn học: ")) {
                if (line.equals("Danh sách đăng kí môn học: ")) {
                    continue;
                }

                String[] dataSubject = line.split(",");
                System.out.println(Arrays.toString(dataSubject));
                SubjectType subjectType = SubjectType.valueOf(SubjectType.class, dataSubject[3].trim().toUpperCase());
                Subject subject = new Subject(dataSubject[1], Integer.parseInt(dataSubject[2]), subjectType);
                LocalDateTime registerTime = LocalDateTime.parse(dataSubject[4].replace("đăng kí lúc ", "").trim());
                listSubject.put(subject, registerTime);
            }

            if (registerSubject != null) {
                registerSubject.registerSubject(listSubject);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return registerSubject;
    }
}
