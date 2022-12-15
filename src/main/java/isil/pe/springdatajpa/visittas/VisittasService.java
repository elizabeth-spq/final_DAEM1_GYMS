package isil.pe.springdatajpa.visittas;

import java.util.List;

public interface VisittasService {


 VisittasDto addVisittas(Visittas visittas);
  Visittas findVisittasByDni(String dni);
  List<Visittas> findAll();
  VisittasDto updateVisittas(Visittas user, Long id);
  void deleteVisittas(Long id);

  Visittas findVisittasById(Long id);

}
