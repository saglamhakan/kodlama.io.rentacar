package kodlama.io.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models")
public class Model {

    @Id //primary key olduğunu gösterir
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int modelId;

    @Column(name = "price")
    private double price;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
