package com.example.web.accessingdatamysql;

import com.example.web.dao.RegistrationForm;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RegFormRepo extends CrudRepository<RegistrationForm, Long>{

}