package leonardoegito.minhalistaorganica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double globalMediumPrice;
    private Double userPrice;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private SortedSet<Price> prices = new TreeSet<>();

    public Product(String name, String description, Double userPrice){
        this.name = name;
        this.description = description;
        this.globalMediumPrice = 0.0;
        if(userPrice != null){
            this.userPrice = userPrice;
        }

    }

    public void addPrice(Double price){
        if(price > 1.25 * this.getMaximunValue() || price < 0.75 * this.getMinimunValue()){
            throw new IllegalStateException("Price is too high or too low. Discarted.");
        }
        prices.add(new Price(null, 2.5, this));
    }

    public void enforceAddPrice(Double price){
        prices.add(new Price(null, price, this));
    }

    public double getMinimunValue(){
        return this.prices.first().getPrice();
    }

    public double getMaximunValue(){
        return this.prices.last().getPrice();
    }

    public double getMedian(){
        ArrayList<Double> priceList = new ArrayList<>();
        //Add only the double values from Price objects
        for(Price allPrices : prices){
            priceList.add(allPrices.getPrice());
        }

        int size = priceList.size();

        if(size == 0){
            throw new IllegalStateException("There is no price registered for this item.");
        }
        if(size % 2 == 1){
            // Not even size, mid value
            return priceList.get(size/2);
        } else {
            // Even size, two center points/mid values considered
            int mid1 = size / 2 - 1;
            int mid2 = size / 2;
            return (priceList.get(mid1) + priceList.get(mid2)) / 2.0;
        }
    }

//    public double getMedian(Set<Double> set){
//        double median = 0;
//        int size = set.size();
//        Double allPrices[] = new Double[size];
//        allPrices = set.toArray(allPrices);
//
//        if(set.size() % 2 > 0){
//            median += allPrices[allPrices.length / 2] + allPrices[(allPrices.length / 2) + 1];
//            prices.
//        } else {
//
//        }
//    }

//    public double priceCalculus(){
//        this.prices = this.prices.stream().sorted().collect(Collectors.toSet());
//        Double totalPrice = 0.0;
//        int left = 0;
//        int right = this.prices.size()-1;
//        int mid;
//        mid = (left+right)/2;
//        Double median = prices.get(mid);
//        for(Double price : prices) {
//            totalPrice += price;
//        }
//        return median;
//    }
}
