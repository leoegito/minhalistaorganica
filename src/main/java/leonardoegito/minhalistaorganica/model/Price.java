package leonardoegito.minhalistaorganica.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_price")
public class Price implements Comparable<Price> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="price_id", unique = true)
    private Long id;

    @NonNull
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public int compareTo(Price otherPrice){
        return Double.compare(this.price, otherPrice.price);
    }

}
