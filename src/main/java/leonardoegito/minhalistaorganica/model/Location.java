package leonardoegito.minhalistaorganica.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Double lat_coordinate;
    @NonNull
    private Double lng_coordinate;
    private String zipCode;
    private String address;

}
