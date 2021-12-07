package com.example.web.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import com.example.web.dao.PersonForm;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FormRepository extends CrudRepository<PersonForm, Long> {

}