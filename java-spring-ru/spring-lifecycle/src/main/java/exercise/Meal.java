package exercise;

import jakarta.annotation.PostConstruct;

// BEGIN
import org.springframework.stereotype.Component;

@Component
// END
public class Meal {
    public String getMealForDaytime(String daytime) {

        return switch (daytime) {
            case "morning" -> "breakfast";
            case "day" -> "lunch";
            case "evening" -> "dinner";
            default -> "nothing :)";
        };
    }

    // Для самостоятельной работы
    // BEGIN

    // END
}
