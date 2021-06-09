package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassController {

    private final ClassesService service;

    @Autowired
    public ClassController(ClassesService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView classes() {
        return new ModelAndView("index")
                .addObject("classes", service.allClasses());
    }

    @GetMapping("/{id}/{trida}")
    public ModelAndView trida(@PathVariable Short id) {
        return new ModelAndView("trida_detail")
                .addObject("trida", service.trida(id));
    }

    @GetMapping("/student{student_id}/{prijmeni}")
    public ModelAndView trida(@PathVariable Integer student_id) {
        return new ModelAndView("student")
                .addObject("student", service.student(student_id));
    }
//    @GetMapping(path = "/post/{slug}")
//    public ModelAndView singlePost(@PathVariable String slug) {
//        return new ModelAndView("post_detail")
//                .addObject("post", service.singlePost(slug));
//    }

}
