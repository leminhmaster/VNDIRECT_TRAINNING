import java.awt.*;

public class CheckBoxExample extends Frame {
    public CheckBoxExample(){
        setLayout(new FlowLayout());
        Checkbox checkbox1 = new Checkbox("Lựa chọn 1");
        checkbox1.setFont(new Font("Arial",Font.BOLD,14));
        add(checkbox1);

        final Checkbox checkbox2 = new Checkbox("Checkbox 2");
        add(checkbox2);
        checkbox2.addItemListener(e->{
            System.out.println("value 2 = "+checkbox2.getState());
        });
        Button btn = new Button("Open AWT simple");
        add(btn);
        btn.addActionListener(new ShowExampleActionListener());
    }
}
