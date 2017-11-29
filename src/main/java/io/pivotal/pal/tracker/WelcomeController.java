package io.pivotal.pal.tracker;

<<<<<<< HEAD

=======
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
<<<<<<< HEAD


    private final String message;
=======
    private String message;
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7

    public WelcomeController(@Value("${WELCOME_MESSAGE}") String message) {
        this.message = message;
    }

    @GetMapping("/")
    public String sayHello() {
<<<<<<< HEAD
        return this.message;
    }
}

=======
        return message;
    }
}
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
