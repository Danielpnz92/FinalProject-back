package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.AllergensValues;
import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.Restaurant;
import FinalProject.FinalProject.repository.AllergensValuesRepository;
import FinalProject.FinalProject.repository.PlatesRepository;
import FinalProject.FinalProject.service.interfaces.IAllergensValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AllergensValuesService implements IAllergensValuesService {
    @Autowired
    AllergensValuesRepository allergensValuesRepository;
    public AllergensValues getAllergensValuesById(Integer id) {
        Optional<AllergensValues> allergensValuesOptional = allergensValuesRepository.findById(id);
        if (allergensValuesOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
        return allergensValuesOptional.get();
    }

    public void createAllergensValues(AllergensValues allergensValues) {
        allergensValuesRepository.save(allergensValues);
    }
}
