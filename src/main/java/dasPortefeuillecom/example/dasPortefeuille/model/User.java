package dasPortefeuillecom.example.dasPortefeuille.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;

    @NotEmpty(message = "Name must not be empty")
    @Column(nullable = false, length = 20)
    private String firstName;

    @NotEmpty(message = "lastName must not be empty")
    @Column(nullable = false, length = 20)
    private String lastName;

    @NotEmpty(message = "email must not be empty")
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @NotEmpty(message = "password must not be empty")
    @Column(nullable = false, length = 64)
    private String password;

    @NotEmpty(message = "phoneNumber must not be empty")
    @Column(nullable = false, unique = true)
    private String phoneNumber;


    public User(){

    }

    public User(long id, String firstName, String lastName, String email, String password, String phoneNumber){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return  lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPhoneNumber(){
        return  phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
