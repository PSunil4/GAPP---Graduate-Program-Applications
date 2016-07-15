package gapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcademicRecords {

    // required only for international - Citizenship
    @Column(name = "toefl_score", nullable = true)
    private int TOEFLScore;

    @Column(name = "gpa")
    private double GPA;

    private String transcript;

    public int getTOEFLScore()
    {
        return TOEFLScore;
    }

    public void setTOEFLScore( int tOEFLScore )
    {
        TOEFLScore = tOEFLScore;
    }

    public double getGPA()
    {
        return GPA;
    }

    public void setGPA( double gPA )
    {
        GPA = gPA;
    }

    public String getTranscript()
    {
        return transcript;
    }

    public void setTranscript( String transcript )
    {
        this.transcript = transcript;
    }

}
