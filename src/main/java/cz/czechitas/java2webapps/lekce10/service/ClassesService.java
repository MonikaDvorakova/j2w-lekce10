package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.entity.Ucitel;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import cz.czechitas.java2webapps.lekce10.repository.UcitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {

    private RodicRepository rodicRepository;
    private StudentRepository studentRepository;
    private TridaRepository tridaRepository;
    private UcitelRepository ucitelRepository;

    @Autowired
    public ClassesService(RodicRepository rodicRepository, StudentRepository studentRepository, TridaRepository tridaRepository, UcitelRepository ucitelRepository) {
        this.rodicRepository = rodicRepository;
        this.studentRepository = studentRepository;
        this.tridaRepository = tridaRepository;
        this.ucitelRepository = ucitelRepository;
    }

    public List<Trida> allClasses() {
        return tridaRepository.findAll();
    }

    public Trida trida(Short id) {
        return tridaRepository.findTridaById(id);
    }

    public Object student(Integer student_id) {
        return studentRepository.findStudentById(student_id);
    }

//    public Ucitel tridniUcitel(Integer ucitelId) {
//        return ucitelRepository.findUcitelById(ucitelId);
//    }
}
