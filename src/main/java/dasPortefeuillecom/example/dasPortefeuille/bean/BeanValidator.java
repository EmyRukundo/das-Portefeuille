package dasPortefeuillecom.example.dasPortefeuille.bean;


import dasPortefeuillecom.example.dasPortefeuille.model.User;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.springframework.stereotype.Component;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Set;

@Component
public class BeanValidator {

    private Object user;

    public jakarta.validation.Validator getValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    public ArrayList<String> userValidate(User user){
        ArrayList<String> arrayList = new ArrayList<>();
        Set<ConstraintViolation<User>> constraintViolations = getValidator().validate(user);
        for(ConstraintViolation<User> constraintViolation : constraintViolations){

            if(constraintViolation.getPropertyPath().toString().equals("name")){
                arrayList.add(constraintViolation.getMessage());
            }

            if(constraintViolation.getPropertyPath().toString().equals("email")){
                arrayList.add(constraintViolation.getMessage());
            }

            if(constraintViolation.getPropertyPath().toString().equals("password")){
                arrayList.add(constraintViolation.getMessage());
            }
        }
        return arrayList;
    }
}
