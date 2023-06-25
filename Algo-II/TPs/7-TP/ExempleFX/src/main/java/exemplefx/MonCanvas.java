package exemplefx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Un canvas est un élément d'interface graphique qui permet de dessiner. Nous
// créons ici notre propre canvas pour lui ajouter des fonctionnalités
// spécifiques. On voudra pouvoir dessiner une forme spécifique à des un
// endroit spécifique. Cette forme sera centrée en x mais pourra monter ou
// descendre.
public class MonCanvas extends Canvas {

    // Coordonnée y de la forme.
    private double y;
    // Si drawSquare est vrai, on dessine un carré. Sinon, on dessine un
    // cercle.
    private boolean drawSquare;
    // De combien de pixels ont va déplacer la forme dans les méthodes up et
    // down.
    private double increment;
    // Rayon de la forme.
    private double size;
    // Si vrai, on dessine la forme en rouge. Sinon, en bleu.
    private boolean red;

    public MonCanvas(double width, double height) {
        super(width, height);
        // La fonction reset permet de tout remettre à zéro. Mais elle sert
        // aussi à initialiser. On pourrait imaginer ajouter un bouton reset
        // dans l'interface. Voyez-vous comment ?
        reset();
    }

    public void reset() {
        this.y = getHeight() / 2;
        this.drawSquare = false;
        this.increment = 10;
        this.size = 100;
        this.red = false;
        // Quand on a tout initialisé, on dessine.
        draw();
    }

    public void setIncrement(double inc) {
        this.increment = inc;
    }

    public void setDrawSquare(boolean drawsq) {
        this.drawSquare = drawsq;
        // A chaque fois qu'on change un paramètre, on va redessiner la forme
        // avec ces changements. On voit ici un exemple où les méthodes set
        // sont importantes. Ce comportement de redessiner automatiquement ne
        // serait pas possible si drawSquare était publique.
        draw();
    }

    public void setSize(double s) {
        this.size = s;
        draw();
    }

    public void toggleRed() {
        this.red = !red;
        draw();
    }

    public void up() {
        // Dans un canvas, l'axe y est inversé. Le point (0,0) est en haut à
        // gauche va vers le bas. Le point en bas à droite sera donc (width,
        // height) avec width et height la largeur et la hauteur du canvas
        // respectivement. Pour dessiner la forme plus haut, on va donc
        // diminuer la valeur y.
        this.y -= this.increment;
        draw();
    }

    public void down() {
        this.y += this.increment;
        draw();
    }

    // Cette méthode va dessiner la forme avec tous les paramètres.
    private void draw() {
        // On ne peut pas utiliser directement les attributs width et height de
        // Canvas car elles sont privées et donc pas accessibles dans notre
        // sous-classe. On doit donc utiliser getWidth et getHeight.
        double width = this.getWidth();
        double height = this.getHeight();
        // xc est la coordonnée x correspondant au centre du canvas.
        double xc = width / 2;
        // Un GraphicsContext est un objet qui permet de dessiner sur un
        // Canvas. Il possède beaucoup de méthodes spécifiques comme strokeLine
        // pour dessiner une ligne.
        GraphicsContext gc = this.getGraphicsContext2D();
        // La méthode clearRect fonctionne comme une gomme. Il efface tous les
        // dessins se trouvant à l'intérieur. Sans cela, les dessins
        // précédents restent affichés. Essayez de commenter cette ligne pour
        // voir ce que ça donne.
        gc.clearRect(0, 0, width, height);
        // On va dessiner un rectangle pour bien voir les limites du canvas.
        // Vous verrez que sa taille reste constante.
        gc.strokeRect(1, 1, width-2, height-2);
        // Selon la valeur de red, on choisis la couleur à utiliser. La méthode
        // setFill configure la couleur pour le remplissage (l'intérieur des
        // formes). Pour choisir la couleur des lignes, on utilise setStroke.
        if (red) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.BLUE);
        }
        // Si vrai, on dessine un carré. Pour cela, la méthode fillRect dessine
        // un carré et le colore avec la couleur configurée ci-dessus. Sinon,
        // on dessine un cercle avec fillOval.
        if (this.drawSquare) {
            gc.fillRect(xc-size, y-size, 2*size, 2*size);
        } else {
            gc.fillOval(xc-size, y-size, 2*size, 2*size);
        }
    }
}
