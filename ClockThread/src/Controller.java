import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    ClockGui clock;

    public Controller(ClockGui clock) {
        this.clock = clock;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clock.btn) {
            String date = clock.txt.getText();
            ClockGui clock1 = new ClockGui(clock.txt.getText());
            clock1.txt.setText(date);
        }
    }
}