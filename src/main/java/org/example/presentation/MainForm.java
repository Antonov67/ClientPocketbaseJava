package org.example.presentation;

import org.example.Classroom;
import org.example.ResponseByClass;
import org.example.service.RetrofitService;
import org.example.service.SimpleDataCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {

    private static RetrofitService retrofitService;
    private static List<String> classrooms = new ArrayList<>();

    public MainForm(){

        retrofitService = new RetrofitService();

        setBounds(100,100,600,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField classroomField = new JTextField();
        classroomField.setBounds(10,10,250,50);
        add(classroomField);

        JButton addButton = new JButton("добавить класс");
        addButton.setBounds(10,80, 250,50);
        add(addButton);

        JButton resetButton = new JButton("обновить");
        resetButton.setBounds(10,150,250,50);
        add(resetButton);

        JList list = new JList();
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 220, 250, 150);
        add(scrollPane);

        DefaultListModel<String> model = new DefaultListModel<>();

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrofitService.getAllClassrooms(new SimpleDataCallback<ResponseByClass>() {
                    @Override
                    public void load(ResponseByClass data) {
                        for (Classroom c : data.items){
                            model.addElement(c.getName());
                        }
                        list.setModel(model);
                    }
                });
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!classroomField.getText().isEmpty()){
                    Classroom classroom = new Classroom(classroomField.getText());
                    retrofitService.createClassroom(classroom, new SimpleDataCallback<Classroom>() {
                        @Override
                        public void load(Classroom data) {
                            addButton.setText("Класс " + data.getName() + " добавлен");
                        }
                    });
                }
            }
        });

        setVisible(true);
    }


}
