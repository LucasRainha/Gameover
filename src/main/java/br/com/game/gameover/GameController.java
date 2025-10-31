package br.com.game.gameover;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    private static final List<String> store = new ArrayList<>();
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("itens", List.of("Relatório", "Métricas", "Exportação"));
        return "dashboard";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Let's Login to the Game");
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute LoginForm loginForm, Model model) {
        model.addAttribute("message", "Login realizado com sucesso!");
        return "dashboard";
    }


    @GetMapping("/do-something")
    public String doSomething(Model model) {
        store.add("Novo registro " + LocalDateTime.now());
        model.addAttribute("message", "Feito com sucesso!");
        model.addAttribute("items", new ArrayList<>(store));
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("pageTitle", "Dashboard");
        return "dashboard";
    }
}
