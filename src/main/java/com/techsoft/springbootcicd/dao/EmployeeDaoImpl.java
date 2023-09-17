package com.techsoft.springbootcicd.dao;

import com.techsoft.springbootcicd.model.Employee;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<Employee>();
        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setEmpId((String) row.get("empId"));
            emp.setEmpName((String) row.get("empName"));
            result.add(emp);
        }

        return result;
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee " +
                "(empId, empName) VALUES (?, ?)";
        getJdbcTemplate().update(sql, employee.getEmpId(), employee.getEmpName());

    }
}