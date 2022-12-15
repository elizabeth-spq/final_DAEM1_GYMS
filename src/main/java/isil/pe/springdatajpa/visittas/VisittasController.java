package isil.pe.springdatajpa.visittas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/visitas")
public class VisittasController {

  @Autowired
  private VisittasService visittasService;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("listVisitas", visittasService.findAll());
    return "visitas/index";
  }

  @GetMapping("/register")
  public String register() {

    return "visitas/register";
  }

  @GetMapping("/update")
  public String update(@RequestParam("id") Long id, Model model) {
    model.addAttribute("visiToUpdate", visittasService.findVisittasById(id));
    return "visitas/update";
  }

  @GetMapping("/create")
  public String create() {

    return "visitas/register";
  }

  @PostMapping("/register")
  public String registerVisita(Visittas visittas, Model model) {

    VisittasDto visittasDto = visittasService.addVisittas(visittas);

    if (visittasDto.getCode().equals("200")) {
      return "redirect:/visitas";
    }
    model.addAttribute("response", visittasDto.getMessage());
    return "ValidationResponse";
  }

  @PostMapping("/update")
  public String updateVisita(Visittas visittas, Model model) {
    VisittasDto visittasDto = visittasService.updateVisittas(visittas, visittas.getId());

    if (visittasDto.getCode().equals("200")) {
      return "redirect:/visitas";
    } else {
      model.addAttribute("response", visittasDto.getMessage());
      return "ValidationResponse";
    }
  }

  @DeleteMapping("/delete")
  public String deleteVisita(@RequestParam("id") Long id) {
    visittasService.deleteVisittas(id);
    return "redirect:/visitas";
  }



}
