package tours_hanoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HanoiFrame extends JFrame implements HanoiState.Listener {

    private final HanoiState state;
    private final int delay;

    public static final int MARGIN_X = 10;
    public static final int MARGIN_Y = 10;
    public static final int TOWER_W = 10; // Largeur d'une tour
    public static final int DISK_H = 30; // Hauteur d'un disque

    public static final Color DISK_COLOR = Color.BLUE;

    private class HanoiPanel extends JPanel {

        /** Dessine la tour d'index i
         *
         * @param g contexte graphique
         * @param i index de la tour (0 <= i < NUM_TOWERS)
         */
        private void drawTower(Graphics g, int i) {
            int w = getWidth();
            int h = getHeight();
            int tw = (w - (2 + HanoiState.NUM_TOWERS - 1) * MARGIN_X) / HanoiState.NUM_TOWERS; // largeur espace tour
            g.fillRect(MARGIN_X + tw / 2 + i * tw - TOWER_W / 2, MARGIN_Y, TOWER_W, h - 2 * MARGIN_Y);
        }

        /** Dessine un disque de taille size sur la tour i en hauteur j
         *
         * @param g contexte graphique
         * @param i index de la tour (0 <= i < NUM_TOWERS)
         * @param j hauteur du disque (0 <= j)
         * @param size taille du disque (0 <= size < MAX_DISKS)
         */
        private void drawDisk(Graphics g, int i, int j, int size) {
            int w = getWidth();
            int h = getHeight();
            int tw = (w - (2 + HanoiState.NUM_TOWERS - 1) * MARGIN_X) / HanoiState.NUM_TOWERS; // largeur espace tour
            int x = MARGIN_X + tw / 2 + i * tw;
            int y = h - MARGIN_Y - (j + 1) * DISK_H;
            int pw = TOWER_W + (int) (1.0 * (tw - TOWER_W) * (size + 1) / HanoiState.MAX_DISKS);

            g.setColor(DISK_COLOR);
            g.fillRect(x - pw / 2, y, pw, DISK_H);
            g.setColor(Color.BLACK);
            g.drawRect(x - pw / 2, y, pw, DISK_H);
        }

        /** Dessine les tours et disques sur base de l'état du jeu */
        @Override
        public void paintComponent(Graphics g) {
            for (int i = 0; i < HanoiState.NUM_TOWERS; i++) {
                drawTower(g, i);
                for (int j = 0; j < state.getNumDisks(i); j++)
                    drawDisk(g, i, j, state.getDiskSize(i, j));
            }
        }
    }

    private JLabel labelCountMoves;

    /** Crée une instance de fenêtre représentant l'état du jeu
     *
     * @param state état du jeu
     * @param delay délai en millisecondes attendu après chaque mise à jour
     */
    public HanoiFrame(HanoiState state, int delay) {
        super("Tours de Hanoï");
        this.state = state;
        this.delay = delay;

        state.addListener(this);

        JPanel outerPanel = new JPanel(new BorderLayout());
        add(outerPanel);
        JPanel topPanel = new JPanel(new FlowLayout());
        labelCountMoves = new JLabel("0 déplacements");
        topPanel.add(labelCountMoves);
        outerPanel.add(new HanoiPanel(), BorderLayout.CENTER);
        outerPanel.add(topPanel, BorderLayout.NORTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /** Met à jour la représentation graphique du jeu */
    @Override
    public void stateChanged() {
        int mc = state.getMovesCount();
        labelCountMoves.setText(mc + " déplacement" + (mc > 1 ? "s" : ""));
        repaint();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
