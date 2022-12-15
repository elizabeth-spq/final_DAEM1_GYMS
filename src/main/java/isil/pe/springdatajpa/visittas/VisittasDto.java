package isil.pe.springdatajpa.visittas;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VisittasDto {

  private String code;
  private String message;
  private Object data;

  public static VisittasDto whenUserDniAlreadyExists() {
    return VisittasDto.builder().code("510").message("DNI ya existe").build();
  }

  public static VisittasDto whenAfiliacioDniNotExists() {
    return VisittasDto.builder().code("510").message("No existe un afiliado con ese DNI").build();
  }

  public static VisittasDto whenError(String message) {
    return VisittasDto.builder().code("500").message("Something went wrong ".concat(message)).build();
  }

  public static VisittasDto whenRegistratioSucced() {
    return VisittasDto.builder()
            .code("200")
            .message("Visit has been registered successfully")
            .build();
  }
  public static VisittasDto whenRegistrationSucced() {
    return VisittasDto.builder()
            .code("200")
            .message("Visit has been registered successfully")
            .build();
  }



}
