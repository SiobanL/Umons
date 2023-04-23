package exemplefx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.Timer;
import java.util.TimerTask;

// La classe principale pour javafx doit hériter de Application.
//
// L'objectif de ce programme est d'afficher une forme (cercle ou carré) que
// l'on pourra déplacer via des boutons. Commencez par exécuter le code pour
// voir ce que ça fait.
//
// Pour ce faire, ouvrez un terminal dans le dossier contenant le fichier
// build.gradle et entrez la commande "gradle run" (sans les guillemets)
//
// Si vous n'avez pas installé gradle, remplacez gradle dans la commande par
// .\gradlew.bat si vous êtes sous windows et ./gradlew si vous êtes sous mac
// ou linux.
public class Main extends Application {

    private CheckBox drawSquare;
    private CheckBox blink;
    private Button up;
    private Button down;
    private MonCanvas canvas;
    private TextField size;
    private TextField increment;
    private Timer blinkTimer;

    public static void main(String[] args) {
        // Méthode statique de Application pour lancer le programme
        launch(args);
    }

    // Méthode appelée quand on initialise la fenêtre. C'est à partir de là
    // qu'on va ajouter les boutons et autres.
    // Stage représente la fenêtre.
    public void start(Stage stage) {
        // Il s'agit d'un layout. Un layout est un objet auquel on va ajouter
        // des éléments (boutons, texte, ...) et qui va gérer comment les
        // placer sur la fenêtre.
        // Le BorderPane découpe la zone en cinq : haut, bas, gauche, droite et
        // centre. Il permet de placer des éléments sur les bords tout en
        // gardant un maximum de place pour le centre où on peut mettre le
        // principal. Par exemple, dans un éditeur de texte, on peut avoir les
        // boutons au dessus et le texte prend la place restante au centre.
        BorderPane root = new BorderPane();

        // On crée deux boutons
        up = new Button("Haut");
        down = new Button("Bas");

        // Une VBox est un autre exemple de layout. Elle va placer les éléments
        // de haut en bas dans l'ordre où on les ajoute. Pour un placement de
        // gauche à droite, on utilise une HBox.
        VBox buttons = new VBox();
        // On ajoute le bouton up en l'ajoutant aux "enfants" de la VBox. Les
        // enfants d'un élément sont ceux qui se trouvent à l'intérieur.
        buttons.getChildren().add(up);
        buttons.getChildren().add(down);
        // On peut aussi demander à la VBox de centrer ses composants.
        buttons.setAlignment(Pos.CENTER);

        // Ici, on place la VBox dans la partie gauche du BorderPane. Cela veut
        // dire que le BorderPane va juste placer tous les éléments de la VBox
        // dans la partie gauche de la fenêtre mais c'est la VBox qui va
        // choisir comment les placer dans cette partie gauche. Ici, de haut en
        // bas car c'est le principe d'une VBox.
        root.setLeft(buttons);

        // On crée une check box avec le texte donné.
        drawSquare = new CheckBox("Dessiner un carré");
        blink = new CheckBox("Clignoter");

        HBox checks = new HBox(drawSquare, blink);
        checks.setAlignment(Pos.CENTER);
        // On place la check box en haut du BorderPane et donc en haut de la
        // fenêtre comme le BorderPane sera le contenu principal de la fenêtre.
        root.setTop(checks);

        // Un GridPane est un layout qui place ses éléments sous forme de
        // grille. On peut y ajouter chaque élément dans une certaine ligne et
        // une certaine colonne.
        GridPane texts = new GridPane();
        // On crée un Label qui correspond à un simple texte. Ce Label sera
        // placé dans la ligne 0 et la colonne 0 du GridPane. C'est à dire,
        // dans la case en haut à gauche.
        texts.add(new Label("Taille de la forme (rayon) :"), 0, 0);
        // Un TextField permet d'entrer du texte.
        size = new TextField();
        // On place le TextField pour la taille de la forme dans la première
        // ligne et dans la deuxième colonne du GridPane.
        texts.add(size, 1, 0);
        texts.add(new Label("Distance du déplacement :"), 0, 1);
        increment = new TextField();
        texts.add(increment, 1, 1);
        texts.setAlignment(Pos.CENTER);

        root.setBottom(texts);

        // On crée un canvas personnalisé (voir MonCanvas.java)
        canvas = new MonCanvas(800, 600);
        // Le canvas pourra utiliser toute la place restante au centre. Mais
        // comme les canvas de JavaFX ont une taille fixe, il ne changera pas
        // de taille si on change la taille de la fenêtre. Pour cela, il
        // faudrait modifier notre canvas.
        root.setCenter(canvas);

        // La scène représente ce qui sera affiché dans la fenêtre.
        // Une scène à besoin d'un layout. C'est pour ça qu'on lui donne root
        // qui sera le layout principal.
        Scene scene = new Scene(root);

        // On configure la scène à afficher.
        stage.setScene(scene);

        // Cette méthode définie plus bas va configurer tous les éléments qui
        // doivent réagir à certains évènements. Par exemple, que faire quand
        // on clique sur un bouton.
        this.confHandlers(stage);

        // On configure le titre de la fenêtre
        stage.setTitle("Ma fenêtre");

        // En général, c'est la dernière instruction de start. On dit à javafx
        // d'afficher la fenêtre (sinon elle ne sera pas visible).
        stage.show();
    }

    private void confHandlers(Stage stage) {
        // Dans une interface graphique, on utilise de la programmation
        // évènementielle. C'est à dire qu'on va exécuter certaines fonctions
        // quand un évènement particulier se produit. Par exemple, cliquer sur
        // un bouton. Le code à exécuter est donné par un objet appelé le
        // "handler". Une sous-classe de EventHandler pour JavaFX.
        // Ci-dessous, on crée une classe anonyme qui sera sous-classe de
        // EventHandler pour les KeyEvent (pour le clavier). Sa méthode handle
        // va faire monter ou descendre la forme du canvas selon la touche
        // enfoncée. La syntaxe <KeyEvent> veut juste dire qu'on ne gère que
        // les KeyEvent. Donc que les touches du clavier et pas, par exemple,
        // la souris.
        EventHandler keyhandler = new EventHandler<KeyEvent>() {
            public void handle(KeyEvent evt) {
                // Le code est celui de la touche utilisée. Ceux-ci sont
                // contenus dans la classe KeyCode. KeyCode.UP est le code pour
                // la flèche du haut.
                KeyCode code = evt.getCode();
                if (code == KeyCode.UP) {
                    // Si on a appuyé sur la flèche du haut, on fait monter la
                    // forme dans le canvas.
                    canvas.up();
                } else if (code == KeyCode.DOWN) {
                    canvas.down();
                }
            }
        };
        // On ajoute le handler à la fenêtre. On précise bien qu'on ne
        // s'intéresse que aux évènements KEY_PRESSED qui correspondent à une
        // touche qui a été enfoncée. Par opposition, KEY_RELEASED correspond à
        // une touche qui a été relachée.
        stage.addEventFilter(KeyEvent.KEY_PRESSED, keyhandler);

        // Les handlers peuvent aussi être donnés via une expression lambda. La
        // fonction doit prendre un évèment en paramètre. Comme ici, up est un
        // bouton, les détails de l'évènement ne nous intéresse pas car il
        // s'agit juste d'un clic sur le bouton.
        //this.up.setOnAction(evt -> this.canvas.up());
        this.up.setOnAction(evt -> this.canvas.up());
        this.down.setOnAction(evt -> this.canvas.down());

        // On remarque ici qu'on prend une propriété (selectedProperty). Il
        // s'agit d'un attribut particulier sur lequel on peut ajouter des
        // handlers pour gérer les cas où la valeur change. Ici, la propriété
        // "selected" indique si la checkbox est cochée ou pas.
        // On ajoute un listener qui est une forme de handler qui gère les cas
        // où des valeurs changent. On reçoit trois paramètres : l'objet
        // lui-même (la checkbox), la valeur avant le changement et la valeur
        // après. Avant et après sont des booléens ici (voir documentation de
        // CheckBox).
        this.drawSquare.selectedProperty().addListener(
                (box, avant, apres) -> {
                    // On n'a pas besoin de la valeur précédente. Juste de la
                    // nouvelle valeur indiquant si la case est cochée (true)
                    // ou pas (false).
                    this.canvas.setDrawSquare(apres);
                }
                );
        // Comme ci-dessus, on ajoute un handler pour mettre à jour la taille
        // de la forme quand on change la valeur dans le TextField. Sans
        // surprise, avant et apres sont des String.
        this.size.textProperty().addListener(
                (field, avant, apres) -> {
                    try {
                        this.canvas.setSize(Double.parseDouble(apres));
                    } catch (NumberFormatException e) {
                        // Ici, on ignore le problème.
                        // On pourrait afficher un message d'erreur dans une
                        // vraie application ou utiliser une pop-up.
                    }
                }
                );
        this.increment.textProperty().addListener(
                (observable, avant, apres) -> {
                    try {
                        this.canvas.setIncrement(Double.parseDouble(apres));
                    } catch (NumberFormatException e) {
                    }
                }
                );

        // Pour activer ou désactiver le clignotement, on utilise un Timer. La
        // checkbox blink va donc soit activer le timer toutes les 2 secondes,
        // soit le désactiver selon qu'elle soit cochée ou pas.
        this.blinkTimer = new Timer();
        this.blink.selectedProperty().addListener(
                (observable, avant, apres) -> {
                    if (!apres) {
                        // Si on vient de décocher blink, on arrête le timer et
                        // on en crée un nouveau qui ne sera pas lancé.
                        blinkTimer.cancel();
                        blinkTimer = new Timer();
                    } else {
                        // Si on vient de cocher blink, on lance le timer après
                        // 2 secondes (2000 ms) et à intervalles de 2 secondes.
                        blinkTimer.scheduleAtFixedRate(new BlinkingTask(canvas), 0, 2000);
                    }
                }
                );

        // Dernier handler, si on ferme la fenêtre, on arrête le timer.
        stage.setOnCloseRequest(evt -> this.blinkTimer.cancel());
    }

    private class BlinkingTask extends TimerTask {
        private MonCanvas canvas;

        public BlinkingTask(MonCanvas c) {
            this.canvas = c;
        }

        public void run() {
            this.canvas.toggleRed();
        }
    }
}
