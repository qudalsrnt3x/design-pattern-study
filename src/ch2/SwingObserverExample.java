package ch2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();

        JButton button = new JButton("할까? 말까?");

        // 람다식으로 변환
        button.addActionListener(e -> {
            System.out.println("하지마! 아마 후회할 걸?");
        });

        button.addActionListener(e -> {
            System.out.println("그냥 저질러 버려!!");
        });

        // 프레임 속성을 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
