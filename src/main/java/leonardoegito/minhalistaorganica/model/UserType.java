package leonardoegito.minhalistaorganica.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserType {

    @Id
    @GeneratedValue
    private Long idUserType;
    private String description;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private List<User> users;

}
