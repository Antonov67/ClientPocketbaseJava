package org.example.presentation;

import org.example.Classroom;
import org.example.service.RetrofitService;
import org.example.service.SimpleDataCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    private static RetrofitService retrofitService;

    public MainForm(){

        retrofitService = new RetrofitService();

        setBounds(100,100,600,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JTextField classroomField = new JTextField();
        classroomField.setBounds(10,10,150,50);
        add(classroomField);

        JButton addButton = new JButton("добавить класс");
        addButton.setBounds(10,80, 150,50);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!classroomField.getText().isEmpty()){
                    Classroom classroom = new Classroom(classroomField.getText());
                    retrofitService.createClassroom(classroom, new SimpleDataCallback<Classroom>() {
                        @Override
                        public void load(Classroom data) {
                            addButton.setText(data.getName());
                        }
                    });
                }
            }
        });

        setVisible(true);
    }


}
