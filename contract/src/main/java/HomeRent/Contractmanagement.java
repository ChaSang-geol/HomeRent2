package HomeRent;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Contractmanagement_table")
public class Contractmanagement {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

}
