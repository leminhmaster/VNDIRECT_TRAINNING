package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AWTSimple1 extends Frame {
    private List list;
    public AWTSimple1(){
        //setLayout(new FlowLayout());
        setLayout(new BorderLayout());

        final TextField text = new TextField();
        add(text,BorderLayout.PAGE_START);
        list = new List(4,true);
        IntStream.range(0,10).forEach(i->{
            list.add("Item "+ i);
        });
        add(list,BorderLayout.CENTER);
        Button pushButton = new Button("press me");
        add(pushButton,BorderLayout.PAGE_END);
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(text.getText());
//                AWTSimple1.this.setTitle(text.getText());
                //String [] values = list.getSelectedItems();
                //StringBuilder builder = new StringBuilder();
//                Arrays.stream(values).forEach(value -> {
//                    if (builder.length() > 0) builder.append("; ");
//                    builder.append(value);
//                });
//                text.setText(builder.toString());
                Supplier<StringBuilder> supplier = new Supplier<StringBuilder>() {
                    @Override
                    public StringBuilder get() {
                        return new StringBuilder();
                    }
                };
                BiConsumer<StringBuilder,String> consumer = ((builder, value) ->{
                    if (builder.length() > 0) builder.append(",");
                    builder.append(value);
                });
                //BinaryOperator<StringBuilder> operator = StringBuilder::append;
                BinaryOperator<StringBuilder> operator = new BinaryOperator<StringBuilder>() {
                    @Override
                    public StringBuilder apply(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
                        return stringBuilder.append("stringBuilder2");
                    }
                };
                Function<StringBuilder,String> finished = new Function<StringBuilder, String>() {
                    @Override
                    public String apply(StringBuilder stringBuilder) {
                        return stringBuilder.toString();
                    }
                };
                String[] values = list.getSelectedItems();
                Collector<String,StringBuilder,String> collector = Collector.of(supplier,consumer,operator,finished);
                text.setText(Arrays.stream(values).collect(collector));
//                String [] values1 = list.getSelectedItems();
//                text.setText(Arrays.stream(values1).collect(Collectors.joining(",")));


            }
        });
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu menu = new Menu("File");
        menu.setLabel("hdbshbd");
        menuBar.add(menu);

        MenuItem menuItem = new MenuItem("Exit", new MenuShortcut('X'));
        menu.add(menuItem);
        menuItem.addActionListener(( e)->{
            System.exit(1);
        });
    }
}
