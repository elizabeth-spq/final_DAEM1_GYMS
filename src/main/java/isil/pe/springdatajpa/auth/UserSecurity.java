package isil.pe.springdatajpa.auth;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Data
@Entity
@Table(name="auth_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email"),
})
public class UserSecurity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "email", length = 200)
  private String email;
  private String password;
  private Date createdAt;

  @PostPersist
  public void updateCreatedAt() {
    createdAt = new Date();
  }
}
