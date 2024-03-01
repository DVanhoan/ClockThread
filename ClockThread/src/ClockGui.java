import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClockGui extends JFrame {

    private int id = 1;
    private String strTime;
    public Label lb;
    public JTextArea txt;
    public JButton btn;

    public ClockGui() {
        init();
        Start();
    }

    public ClockGui(String strTime) {
        this.strTime = strTime;
        init();
        System.out.println(strTime);
        SetThread nhanDu = new SetThread(id++, new Time(strTime));
        nhanDu.start();

        new Thread(()->{
            while(true) {
                setTime(nhanDu.getTime().toString());
            }

        }).start();
    }

    public void init() {
        setTitle("Time");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Controller ac = new Controller(this);

        setLayout(new BorderLayout());
        lb = new Label();
        add(lb, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1, 2));
        txt = new JTextArea();
        btn = new JButton("Click");
        btn.addActionListener(ac);
        south.add(txt);
        south.add(btn);

        add(south, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        ClockGui clock = new ClockGui();

    }

    public void Start() {
        new Thread(()->{
            while(true) {
                Time();
            }

        }).start();
    }

    public void Time() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        lb.setText(dateFormat.format(new Date()));
    }

    public void setTime(String strTime) {
        lb.setText(strTime);
    }
}