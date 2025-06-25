package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	  public List<Employee> getAll() {
	        return repository.findAll();
	    }

	    public Employee getById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Employee create(Employee employee) {
	        return repository.save(employee);
	    }

	    public Employee update(Long id, Employee updatedEmployee) {
	        Optional<Employee> optional = repository.findById(id);
	        if (optional.isPresent()) {
	            Employee existing = optional.get();
	            existing.setName(updatedEmployee.getName());
	            existing.setRole(updatedEmployee.getRole());
	            existing.setSalary(updatedEmployee.getSalary());
	            return repository.save(existing);
	        }
	        return null;
	    }

	    public void delete(Long id) {
	        repository.deleteById(id);
	    }

}
