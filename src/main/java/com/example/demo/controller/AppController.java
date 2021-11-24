package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.DisciplineRepository;
import com.example.demo.service.StudentRepository;
import com.example.demo.service.TeacherRepository;


@Controller
public class AppController {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired TeacherRepository teacherRepo;
	@Autowired DisciplineRepository disciplineRepo;
	@GetMapping("")
    public String viewHomePage() {
        return "index";
    }
	@GetMapping("/addStudent")
	public String showStudentAddForm(Model model) {
		model.addAttribute("Student", new Student());
		return "student_form";		
	}
	@PostMapping("/add_student")
	public String addStudentToBase(Student student) {
		studentRepo.save(student);
		
		return "index";
	}
	
	@GetMapping("/addTeacher")
	public String showTeacherAddForm(Model model) {
		model.addAttribute("Teacher", new Teacher());
		return "teacher_form";		
	}
	@PostMapping("/add_teacher")
	public String addTeacherToBase(Teacher teacher) {
		teacherRepo.save(teacher);
		return "index";
	}
	
	@GetMapping("/addDiscipline")
	public String showDisciplineAddForm(Model model) {
		List<Teacher> listTeachers = teacherRepo.findAll();
		model.addAttribute("Discipline", new Discipline());
        model.addAttribute("listTeachers", listTeachers);
		return "discipline_form";	
	}
	@PostMapping("/add_discipline")
	public String addDisciplineToBase(Discipline discipline) {
		disciplineRepo.save(discipline);
		return "index";
	}
	@GetMapping("/changeStudentDiscipline")
	public String changeDiscipline(Model model) {
		List<Student> listStudents = studentRepo.findAll();
        model.addAttribute("listStudents", listStudents);
        List<Discipline> listDisciplines = disciplineRepo.findAll();
        model.addAttribute("listDisciplines", listDisciplines);
        return "changeDiscipline_form";	
	}
	@GetMapping("/changeCurrentStudentDiscipline") 
    public String GettingCurrentStudentDisciplines(@RequestParam(value="studentId") Long studentid,Model model) {
		Student CurrentStudent=studentRepo.getById(studentid);
		Set<Discipline> setDisciplines=CurrentStudent.getDisciplines();
		model.addAttribute("setDisciplines",setDisciplines);
		List<Discipline> listDisciplines=disciplineRepo.findAll();
		model.addAttribute("listDisciplines",listDisciplines);
		model.addAttribute("Student", CurrentStudent);
		return "studentDiscipline";
	}
	@RequestMapping("/changeCurrentStudentDiscipline/AddDiscipline")
    public String GettingDisciplineName(@RequestParam(value="discipline") Long disciplineid,@RequestParam(value="studentId") Long studentid,Model model) {
		Student CurrentStudent=studentRepo.getById(studentid);
		Discipline CurrentDiscipline=disciplineRepo.getById(disciplineid);
		CurrentStudent.addDiscipline(CurrentDiscipline, CurrentStudent);
		studentRepo.save(CurrentStudent);
		Set<Discipline> setDisciplines=studentRepo.getById(studentid).getDisciplines();
		List<Discipline> listDisciplines = new ArrayList<Discipline>(setDisciplines);
		model.addAttribute("listDisciplines",listDisciplines);
        return "studentDiscipline :: testDiscipline-row"; 
        
   }
	@RequestMapping("/changeCurrentStudentDiscipline/RemoveDiscipline")
	public String RemovingDiscipline(@RequestParam(value="discipline") Long disciplineid,@RequestParam(value="studentId") Long studentid,Model model) {
		Student CurrentStudent=studentRepo.getById(studentid);
		Discipline CurrentDiscipline=disciplineRepo.getById(disciplineid);
    	CurrentStudent.RemoveDiscipline(CurrentDiscipline, CurrentStudent);
    	studentRepo.save(CurrentStudent);
    	Set<Discipline> setDisciplines=studentRepo.getById(studentid).getDisciplines();
		List<Discipline> listDisciplines = new ArrayList<Discipline>(setDisciplines);
		model.addAttribute("listDisciplines",listDisciplines);
    	return "studentDiscipline :: testDiscipline-row";
   }
	@PostMapping("/StudentDisciplineSave")   
    public String StudentDisciplineSave () {
    	
    	
    	
    	return "index";
    }
}
