package main.proyecto_movipet.view;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeTransitions {

    public static void applyFadeTransition(Node node, Duration duration, EventHandler<ActionEvent> event) {
        FadeTransition fadeIn = new FadeTransition(duration,node);
        fadeIn.setCycleCount(1);
        fadeIn.setFromValue(0.2);
        fadeIn.setToValue(1);
        fadeIn.setAutoReverse(true);
        fadeIn.setOnFinished(event);

        FadeTransition fadeOut = new FadeTransition(duration,node);
        fadeOut.setCycleCount(1);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0.2);
        fadeOut.setAutoReverse(true);
        fadeOut.setOnFinished(event);

        fadeOut.play();
        fadeOut.setOnFinished((e) -> {
            fadeIn.play();
        });
    }
}
