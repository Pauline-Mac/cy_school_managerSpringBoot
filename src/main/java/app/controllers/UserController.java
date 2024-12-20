package app.controllers;

import app.models.Professor;
import app.models.Student;
import app.models.User;
import app.repositories.ProfessorRepository;
import app.repositories.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.repositories.UserRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

// This means that this class is a Controller
@Controller
// This means URL's start with / (after Application path)
@RequestMapping(path="/")
public class UserController {
  // This means to get the bean called userRepository
  // Which is auto-generated by Spring, we will use it to handle the data
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ProfessorRepository professorRepository;
  @Autowired
  private StudentRepository studentRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser (
          @RequestParam String email,
          @RequestParam String password,
          @RequestParam String last_name,
          @RequestParam String first_name,
          @RequestParam String phone,
          @RequestParam String birth_date
  ) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    user.setLastName(last_name);
    user.setFirstName(first_name);
    user.setPhone(phone);
    user.setEmail(email);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    formatter = formatter.withLocale(Locale.FRENCH);
    LocalDate date = LocalDate.parse(birth_date, formatter);
    user.setBirthDate(date);
    userRepository.save(user);
    return "Saved";
  }
}