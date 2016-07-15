package gapp.model.dao.jpa;

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.ProgramCount;
import gapp.model.dao.ProgramDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProgramDaoImpl implements ProgramDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Program getProgram( Integer id )
    {
        return entityManager.find( Program.class, id );
    }

    @Override
    public List<Program> getPrograms()
    {
        return entityManager.createQuery( "from Program where isActive=true order by programId",
            Program.class ).getResultList();
    }

    @Override
    public List<Object[]> listOfPrgPerDept()
    {
        return entityManager.createQuery(
            "select d.departmentId, count(p.programId) as count from Department d left join d.program p with p.isActive=true group by d.departmentId", Object[].class)
            .getResultList();
    }

    @Override
    public List<Program> getProgByDeptId( Integer deptId )
    {
        return entityManager.createQuery( "from Program where department.departmentId = :deptId and isActive = true", Program.class )
            .setParameter( "deptId", deptId ).getResultList();
    }

    @Transactional
    @Override
    public Program addProgram( Program program, Department department)
    {
        program.setDepartment( department );
        program.setActive( true );
        return entityManager.merge( program );
    }

    @Transactional
    @Override
    public void removeProgram( Program program )
    {
        program.setActive( false );
        entityManager.merge( program );
       // entityManager.remove( program );
    }
}
