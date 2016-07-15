package gapp.model;

public class ProgramCount {

    private Integer programDeptId;
    private int count;

    public ProgramCount( Integer programDeptId, int count )
    {
        super();
        this.programDeptId = programDeptId;
        this.count = count;
    }

    public Integer getProgramDeptId()
    {
        return programDeptId;
    }

    public void setProgramDeptId( Integer programDeptId )
    {
        this.programDeptId = programDeptId;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount( int count )
    {
        this.count = count;
    }
}
