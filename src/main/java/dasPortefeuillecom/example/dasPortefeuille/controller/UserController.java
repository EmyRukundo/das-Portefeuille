package dasPortefeuillecom.example.dasPortefeuille.controller;


import dasPortefeuillecom.example.dasPortefeuille.bean.BeanValidator;
import dasPortefeuillecom.example.dasPortefeuille.bean.ResultDTO;
import dasPortefeuillecom.example.dasPortefeuille.model.User;
import dasPortefeuillecom.example.dasPortefeuille.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BeanValidator beanValidator;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User reqData) {
        System.err.println(":::  UserController.createUser :::");
        ResultDTO<?> responsePacket = null;
        try {
            ArrayList<String> errorList = beanValidator.userValidate(reqData);
            if (errorList.size() != 0) {
                ResultDTO<ArrayList<String>> errorPacket = new ResultDTO<>(errorList,
                        "Above fields values must not be empty", false);
                return new ResponseEntity<>(errorPacket, HttpStatus.BAD_REQUEST);
            }
            User isData = userService.isDataExist(reqData);
            if (isData == null) {
                responsePacket = new ResultDTO<>(userService.createUser(reqData), "User Created Successfully", true);
                return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } else {
                responsePacket = new ResultDTO<>("Record already exist", false);
                return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> allUsers() {
        System.err.println(":::  UserController.allUsers :::");
        ResultDTO<?> responsePacket = null;
        try {
            responsePacket = new ResultDTO<>(userService.getAllUsers(), "Users fetched successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        System.err.println(":::  UserController.getUserById :::");
        ResultDTO<?> responsePacket = null;
        try {
            responsePacket = new ResultDTO<>(userService.getUserById(id), "User fetched successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User reqData) {
        System.err.println(":::  UserController.updateUser :::");
        ResultDTO<?> responsePacket = null;
        try {
            User isData = userService.isDataExist(reqData);
            if (isData != null) {
                responsePacket = new ResultDTO<>(userService.updateUser(reqData, isData), "User Updated Successfully",
                        true);
                return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } else {
                responsePacket = new ResultDTO<>("Record not exist", false);
                return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        System.err.println(":::  UserController.deleteUserById :::");
        ResultDTO<?> responsePacket = null;
        try {
            responsePacket = new ResultDTO<>(userService.deleteUserById(id), "User deleted successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }

}