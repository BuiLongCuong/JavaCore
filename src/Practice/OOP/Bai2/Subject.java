package Practice.OOP.Bai2;

enum SubjectType {
    DAI_CUONG,
    CO_SO_NGANH,
    CHUYEN_NGANH_BAT_BUOC,
    CHUYEN_NGANH_TU_CHON,
}
public class Subject {
    private int idSubject;
    private static int idIncrement = 1;
    private String nameSubject;
    private int totalOfLessons;
    private SubjectType subjectType;

    public Subject(String nameSubject, int totalOfLessons, SubjectType subjectType) {
        this.idSubject = idIncrement;
        this.nameSubject = nameSubject;
        this.totalOfLessons = totalOfLessons;
        this.subjectType = subjectType;
        idIncrement++;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getTotalOfLessons() {
        return totalOfLessons;
    }

    public void setTotalOfLessons(int totalOfLessons) {
        this.totalOfLessons = totalOfLessons;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", nameSubject='" + nameSubject + '\'' +
                ", totalOfLessons=" + totalOfLessons +
                ", subjectType=" + subjectType +
                '}';
    }
}
