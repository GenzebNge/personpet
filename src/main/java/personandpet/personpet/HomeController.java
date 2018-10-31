package personandpet.personpet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model)    {

        Person person = new Person();
        person.setName("Stephan");
        person.setGender("Male");


        // Add person to an Empyty list
        Set<Person> persons = new HashSet<Person>();
        persons.add(person);

        Pet pet = new Pet();
        pet.setName("Popy");
        pet.setAge(7);

        // Add list of pets in to person
        Set<Pet>pets = new HashSet<Pet>();
        pets.add(pet);

        person.setPets(pets);
        personRepository.save(person);
        model.addAttribute("person", personRepository.findAll());
        return  "index";

    }

}
