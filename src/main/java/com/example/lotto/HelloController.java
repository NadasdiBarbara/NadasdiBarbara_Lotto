package com.example.lotto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Random;


public class HelloController {
        @FXML
        private Button btnSorsol;

        @FXML
        private Label lblSorsolando, lblSorsoltSzamok;
        private ArrayList<Integer> sorsoltList;
        private Random rnd;

        @FXML
        public void initialize() {
            sorsoltList = new ArrayList<>();
            rnd = new Random();
        }

        @FXML
        public void sorsol() {
            boolean kihuzhato = sorsoltList.size() < 5;
            if (kihuzhato) {
                int szam = rnd.nextInt(91);
                lblSorsolando.setText(String.valueOf(szam));
                sorsoltList.add(szam);
                lblSorsoltSzamok.setText(kiir());
                if (sorsoltList.size() == 5) {
                    btnSorsol.setText("Rendez");
                }
            } else {
                boolean rendez = false;
                int sgeed;
                while (!rendez) {
                    rendez = true;
                    for (int i = 0; i < sorsoltList.size() - 1; i++) {
                        if (sorsoltList.get(i) > sorsoltList.get(i + 1)) {
                            sgeed = sorsoltList.get(i);
                            sorsoltList.set(i, sorsoltList.get(i + 1));
                            sorsoltList.set(i + 1, sgeed);
                            rendez = false;
                        }
                    }
                }
                lblSorsoltSzamok.setText(kiir());
                btnSorsol.setText("Sorsol");
                sorsoltList.clear();
            }

        }

        private String kiir() {
            String sorsoltakString = "";
            for (int szam : sorsoltList) {
                sorsoltakString += String.valueOf(szam) + " ";
            }
            return sorsoltakString;
        }
    }
