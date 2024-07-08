package domain;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="education_info")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="education_id")
    private int educationId;
    @Column(name="tenth_percent")
    private double tenthPercent;
    @Column(name="twelve_percent")
    private double twelvePercent;
    @Column(name="degree")
    private double degree;

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public double getTenthPercent() {
        return tenthPercent;
    }

    public void setTenthPercent(double tenthPercent) {
        this.tenthPercent = tenthPercent;
    }

    public double getTwelvePercent() {
        return twelvePercent;
    }

    public void setTwelvePercent(double twelvePercent) {
        this.twelvePercent = twelvePercent;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }


}
