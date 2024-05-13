package libroswebapp.controller;

import libroswebapp.dao.LibroRepository;
import libroswebapp.entity.EditorialEntity;
import libroswebapp.entity.EscritorEntity;
import libroswebapp.entity.GeneroEntity;
import libroswebapp.entity.LibroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LibroController {


    @Autowired
    protected LibroRepository libroRepository;

    @GetMapping("/")
    public String doListar (Model model) {
        List< LibroEntity> lista = this.libroRepository.findAll();
        model.addAttribute("lista", lista);
        return "listado";
    }

    @GetMapping("/borrar")
    public String doBorrar (@RequestParam("id") Integer id) {
        this.libroRepository.deleteById(id);
        return "redirect:/  ";
    }

    @GetMapping("/editar")
    public String doEditar (@RequestParam("id") Integer id, Model model) {
        LibroEntity libro = this.libroRepository.findById(id).orElse(null);
        model.addAttribute("libro",libro);
        return "libro";
    }

    @GetMapping("/anyadir")
    public String viewAnyadir()
    {
        return "anyadir";
    }

    @PostMapping("/guardar")
    public String doGuardar (@RequestParam("id") Integer id,
                             @RequestParam("titulo") String titulo,
                             @RequestParam("anyo") Short anyo)
    {
        LibroEntity libro = this.libroRepository.findById(id).orElse(null);
        libro.setYearreleased(anyo);
        libro.setLibroname(titulo);
        this.libroRepository.save(libro);

        return "redirect:/";
    }

    @PostMapping("/nuevo")
    public String doAnyadir(@RequestParam("titulo") String titulo,
                            @RequestParam("anyo") Short anyo,
                            @RequestParam("genero") String genero,
                            @RequestParam("autor") String autor,
                            @RequestParam("editorial") String editorial)
    {
        Integer id = searchLibroId();
        LibroEntity libro = new LibroEntity();

        EditorialEntity editorialEntity = new EditorialEntity();
        editorialEntity.setEditorialname(editorial);

        EscritorEntity escritor = new EscritorEntity();
        List<EscritorEntity> escritores = new ArrayList<>();
        escritor.setEscritorname(autor);
        escritores.add(escritor);

        GeneroEntity genre = new GeneroEntity();
        List<GeneroEntity> generos = new ArrayList<>();
        genre.setGeneroname(genero);
        generos.add(genre);


        libro.setLibroname(titulo);
        libro.setYearreleased(anyo);
        libro.setEditorialid(editorialEntity);
        libro.setGeneroList(generos);
        libro.setEscritorList(escritores);

        this.libroRepository.saveAndFlush(libro);
        return "redirect:/";
    }

    private Integer searchLibroId()
    {
        Integer id = 0;

        while(this.libroRepository.findById(id).orElse(null) == null)
        {
            id++;
        }

        return id;
    }

    private Integer searchEditorialId()
    {
        Integer id = 0;

        while(this.libroRepository.findById(id).orElse(null) == null)
        {
            id++;
        }

        return id;
    }

}
