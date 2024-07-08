package domain;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="student_info")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int studentId;
    @Column(name="stud_name")
    private String studentName;
    @Column(name="stud_contact")
    private int contact;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="edu_id")
    private Education eduId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Education getEduId() {
        return eduId;
    }

    public void setEduId(Education eduId) {
        this.eduId = eduId;
    }


}
