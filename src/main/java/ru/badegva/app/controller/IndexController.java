package ru.badegva.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.badegva.app.usecase.AddUnapproved;
import ru.badegva.app.usecase.GetRandomPartnerHref;
import ru.badegva.app.usecase.GetRandomSite;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class IndexController {

    private final AddUnapproved addUnapproved;
    private final GetRandomSite getRandomSite;
    private final GetRandomPartnerHref getRandomPartnerHref;

    public IndexController(
        AddUnapproved addUnapproved,
        GetRandomSite getRandomSite,
        GetRandomPartnerHref getRandomPartnerHref
    ) {
        this.addUnapproved = addUnapproved;
        this.getRandomSite = getRandomSite;
        this.getRandomPartnerHref = getRandomPartnerHref;
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping("/add")
    public String addToReview(@RequestParam("ref") String ref, Model model) {
        addUnapproved.execute(ref);
        model.addAttribute("added", true);
        return "index";
    }

    @GetMapping("/random")
    public String random(
        @RequestParam(value = "ru", required = false) Integer ru,
        @RequestParam(value = "q") Integer clickCount
    ) {
        boolean ruRequired = ru != null && ru == 1;
        String href = (isPartner(clickCount) ? getRandomPartnerHref.execute(ruRequired) : getRandomSite.execute(ruRequired));
        return "redirect:" + href;
    }

    private boolean isPartner(int clickCount) {
        return clickCount % (ThreadLocalRandom.current().nextInt(5, 7)) == 0;
    }

}
