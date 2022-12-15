package isil.pe.springdatajpa.visittas;

import isil.pe.springdatajpa.afiliacion.Afiliacio;
import isil.pe.springdatajpa.afiliacion.AfiliacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;


@Service
public class VisittasServiceImpl implements VisittasService {

  @Autowired
  private VisittasRepository visittasRepository;
  @Autowired
  private AfiliacioRepository afiliacioRepository;

  @Override
  public VisittasDto addVisittas(Visittas visittas) {
    //Optional<Visittas> userToAdd = visittasRepository.findVisittaByDni(visittas.getDni());
    Optional<Afiliacio> afiliado = afiliacioRepository.findAfiliacioByDni(visittas.getDni());
    if (!afiliado.isPresent()) {
      return VisittasDto.whenAfiliacioDniNotExists();
    }
    visittas.setFecha(new Date());
    visittas.setHora(new Date());
    visittasRepository.save(visittas);
    /*

    Optional<Visittas> userToAdd = visittasRepository.findVisittaByDni(visittas.getDni());

    if (userToAdd.isPresent()) {
      return VisittasDto.whenUserDniAlreadyExists();
    }
    visittasRepository.save(visittas);

     */
    return VisittasDto.whenRegistratioSucced();
  }

  @Override
  public Visittas findVisittasByDni(String dni) {
    Optional<Visittas> userToFind = visittasRepository.findVisittaByDni(dni);
    if (userToFind.isPresent()) {
      return userToFind.get();
    } return null;
  }


    @Override
  public List<Visittas> findAll() {

    return visittasRepository.findAll();
  }

  @Override
  public VisittasDto updateVisittas(Visittas visittas, Long id) {
    try {
       Optional<Visittas> visittasToUpdate = visittasRepository.findById(id);
       Optional<Afiliacio> afiliado = afiliacioRepository.findAfiliacioByDni(visittas.getDni());
      if (afiliado.isPresent()) {
        if (visittasToUpdate.isPresent()) {
          visittasToUpdate.get().setLoca(visittas.getLoca() != null ? visittas.getLoca() : visittasToUpdate.get().getLoca());
          visittasToUpdate.get().setDni(visittas.getDni() != null ? visittas.getDni() : visittasToUpdate.get().getDni());
          visittasToUpdate.get().setFecha(new Date());
          visittasToUpdate.get().setHora(new Date());

          visittasRepository.save(visittasToUpdate.get());
          return VisittasDto.whenRegistratioSucced();
        }else {
          return VisittasDto.whenError("No esxiste la visita");
        }


      } else {
        return VisittasDto.whenAfiliacioDniNotExists();
      }


       /*
      if (visittasToUpdate.isPresent()) {

          visittasToUpdate.get().setLoca(visittas.getLoca() != null ? visittas.getLoca() : visittasToUpdate.get().getLoca());
          visittasToUpdate.get().setDni(visittas.getDni() != null ? visittas.getDni() : visittasToUpdate.get().getDni());
          visittasToUpdate.get().setFecha(visittas.getFecha() != null ? visittas.getFecha() : visittasToUpdate.get().getFecha());
          visittasToUpdate.get().setHora(visittas.getHora() != null ? visittas.getHora() : visittasToUpdate.get().getHora());

        visittasRepository.save(visittasToUpdate.get());
        return VisittasDto.whenRegistrationSucced();
      }
      return VisittasDto.whenError("No esxiste la visita");

        */
    } catch (Exception e) {
      return VisittasDto.whenError("Afiliado en uso use otro");
    }
  }
  @Override
  public void deleteVisittas(Long id) {
    Optional<Visittas> visiToDelete = visittasRepository.findById(id);
    visiToDelete.ifPresent(visittas -> visittasRepository.delete(visittas));
  }

  @Override
  public Visittas findVisittasById(Long id) {

    return visittasRepository.findById(id).orElse(null);
  }


}
