package com.example.tourism;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/astana")
    public String getAstana() {
        return "astana";
    }

    @GetMapping("/grandmap")
    public String grandmap() {
        return "grandmap";
    }

    @GetMapping("/almaty")
    public String almaty() {
        return "almaty";
    }

    @GetMapping("/bayanaul")
    public String bayanaul() {
        return "bayanaul";
    }

    @GetMapping("/borovoe")
    public String borovoe() {
        return "borovoe";
    }

    @GetMapping("/imantau-shalkar")
    public String imantaushalkar() {
        return "imantau-shalkar";
    }

    @GetMapping("/east-kazakhstan")
    public String eastkazakhstan() {
        return "east-kazakhstan";
    }

    @GetMapping("/balkash")
    public String balkash() {
        return "balkash";
    }

    @GetMapping("/turkestan")
    public String turkestan() {
        return "turkestan";
    }

    @GetMapping("/ulitau")
    public String ulitau() {
        return "ulitau";
    }
    @GetMapping("/mangistau")
    public String mangistau() {
        return "mangistau";
    }

}