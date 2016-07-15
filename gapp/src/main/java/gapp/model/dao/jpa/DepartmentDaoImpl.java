package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import gapp.model.Department;
import gapp.model.dao.DepartmentDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department getDepartment( Integer deptId )
    {
        return entityManager.find( Department.class, deptId );
    }

    @Override
    public List<Department> getDepartments()
    {
        return entityManager.createQuery(
            "from Department order by departmentId", Department.class )
            .getResultList();
    }

    @Transactional
    @Override
    public Department addDepartment( Department department)
    {
        return entityManager.merge( department );
    }

}
