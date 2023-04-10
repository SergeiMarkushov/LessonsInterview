package lessonseven.controllers;

import lessonseven.entities.Student;
import lessonseven.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> showAll() {
        return studentService.showAll();
    }

    @PostMapping
    public Student addOrUpdateStudent(@RequestBody Student student) {
        return studentService.addOrUpdateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @GetMapping("/{id}")
    public Student findStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }
}
