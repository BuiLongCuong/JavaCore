package Practice.OOP.Bai2;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RegisterSubject {
    private Student student;
    private HashMap<Subject, LocalDateTime> subjectWithTime;
    private ReadAndWriteFile readAndWriteFile;

    public RegisterSubject(Student student) {
        readAndWriteFile = new ReadAndWriteFile();
        this.student = student;

        RegisterSubject savedRegisterSubject = readAndWriteFile.readRegisterSubjectFile();
        if (savedRegisterSubject != null && savedRegisterSubject.getStudent().getIdStudent() == student.getIdStudent()) {
            this.subjectWithTime = savedRegisterSubject.getSubjectWithTime();
        } else {
            this.subjectWithTime = new HashMap<>();
        }
    }

    public void registerSubject(Map<Subject, LocalDateTime> list) {
        for (Map.Entry<Subject, LocalDateTime> subjectEntry : list.entrySet()) {
            if (subjectWithTime.size() <= 8) {
                Subject subject = subjectEntry.getKey();
                LocalDateTime localDateTime = subjectEntry.getValue();
                if (!subjectWithTime.containsKey(subject)) {
                    subjectWithTime.put(subject, localDateTime);
                } else {
                    System.out.println("Môn học '" + subject.getNameSubject() + "' đã được đăng ký trước đó.");
                }
            } else {
                System.out.println("Sinh viên chỉ được phép đăng ký không quá 8 môn học.");
            }
        }
    }


    public void saveToFile() {
        readAndWriteFile.writeRegisterSubjectFile(this);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HashMap<Subject, LocalDateTime> getSubjectWithTime() {
        return subjectWithTime;
    }

    public void setSubjectWithTime(HashMap<Subject, LocalDateTime> subjectWithTime) {
        this.subjectWithTime = subjectWithTime;
    }

    public ReadAndWriteFile getReadAndWriteFile() {
        return readAndWriteFile;
    }

    public void setReadAndWriteFile(ReadAndWriteFile readAndWriteFile) {
        this.readAndWriteFile = readAndWriteFile;
    }

    @Override
    public String toString() {
        return "RegisterSubject{" +
                "student=" + student +
                ", subjectWithTime=" + subjectWithTime +
                ", readAndWriteFile=" + readAndWriteFile +
                '}';
    }
}
