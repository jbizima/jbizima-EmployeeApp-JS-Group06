package tutorial.employeemanagmentbackend.service;

import tutorial.employeemanagmentbackend.model.Employee;
import tutorial.employeemanagmentbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void deleteEmployee(int id) {
        // TODO Auto-generated method stub
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        // TODO Auto-generated method stub
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        // TODO Auto-generated method stub
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmail(employee.getEmail());
        return employeeRepository.save(employeeToUpdate);
    }

}
