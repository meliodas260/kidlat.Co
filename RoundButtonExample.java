import javax.swing.*;
import java.awt.*;

class RoundedCornerButton extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
    }
    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }
    private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        g.setColor(c.getBackground());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 30, 30);
    }
    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        paintBackground(g, b, 0);
    }
}
