package Practice.OOP.Bai2;

import java.util.ArrayList;

public class SubjectManagement {
    private ArrayList<Subject> subjectList;
    private ReadAndWriteFile readAndWriteFile;

    public SubjectManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        this.subjectList = readAndWriteFile.readSubjectFile();
    }

    public void addSubject(Subject newSubject) {
        subjectList.add(newSubject);
        readAndWriteFile.writeSubjectFile(subjectList);
    }

    public void showAll() {
        System.out.println("---------------------- Danh sách môn học ----------------------");
        if(subjectList.isEmpty()){
            System.out.println("Chưa có môn học nào cả!.");
        } else {
            for (Subject subject : subjectList) {
                System.out.println(subject.toString());
            }
        }
        System.out.println("------------------------------------------------------------------");
    }

    public Subject findSubjectById(int id) {
        for (Subject subject : subjectList) {
            if(subject.getIdSubject() == id) {
                return subject;
            }
        }
        return null;
    }
}
