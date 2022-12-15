package isil.pe.springdatajpa.afiliacion;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="tbl_afiliado", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dni", name="unique_dni"),
        @UniqueConstraint(columnNames = "email", name="unique_email")
})
@Data
public class Afiliacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "dni", length = 8)
    private String dni;
    @Column(name = "email", length = 200)
    private String email;
    private Date createdAt;

    @PostPersist
    public void updateCreatedAt() {
        createdAt = new Date();
    }

}
