package dasPortefeuillecom.example.dasPortefeuille.service;


import dasPortefeuillecom.example.dasPortefeuille.model.User;
import dasPortefeuillecom.example.dasPortefeuille.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Object createUser(User reqData) {
        return userRepository.save(reqData);
    }

    public Object getAllUsers() {
        return userRepository.findAll();
    }

    public User isDataExist(User reqData) {
        return userRepository.findByEmailAndPhoneNumber(reqData.getEmail(), reqData.getPhoneNumber());
    }

    public Object getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Object updateUser(User reqData, User isData) {
        isData.setFirstName(reqData.getFirstName());
        isData.setLastName(reqData.getLastName());
        isData.setEmail(reqData.getEmail());
        isData.setPassword(reqData.getPassword());
        isData.setPhoneNumber(reqData.getPhoneNumber());
        return userRepository.save(isData);

    }


public Object deleteUserById(Long id){
    userRepository.deleteById(id);
    return null;
}
}
