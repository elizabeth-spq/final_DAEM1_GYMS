package isil.pe.springdatajpa.visittas;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="tbl_visitas")
@Data
public class Visittas {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String loca;
  @Column(name = "dni", length = 8)
  private String dni;

  private Date fecha;
  private Date hora;

  @PostPersist
  public void updateFechaAndHora() {
/*
    fecha=new Date();

    hora=new Date();

 */
  }

  public String DarFormatoFecha(){
    DateFormat dateFormat2=new SimpleDateFormat("dd/MM/YYYY");
    String formattedDate2=dateFormat2.format(fecha);

    return formattedDate2;
  }
  public String DarFormatoHora(){
    DateFormat dateFormat2=new SimpleDateFormat("hh:mm");
    String formattedDate2=dateFormat2.format(hora);

    return formattedDate2;
  }

}
