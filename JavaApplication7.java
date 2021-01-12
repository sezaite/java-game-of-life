/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author pavet
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] field = new char[50][50];
        char[][] newField = new char[50][50];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (Math.random() < 0.24) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = ',';
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                char target = field[i][j];
                int xCount = 0;
                for (int k = i - 1; k < i + 3; k++) {
                    for (int l = j - 1; l < j + 3; l++) {
                        if (field[k][l] == 'X') {
                            xCount++;
                        }
                    }
                }
                if (target == 'X') {
                    xCount -= 1;
                    if (xCount < 4 && xCount > 1) {
                        newField[i][j] = 'X'; //patikrinti, ar tinka ir field[i][j] vietoj 'X';
                    } else {
                        newField[i][j] = ',';
                    }
                } else {
                    if (xCount == 3) {
                        newField[i][j] = 'X';
                    } else {
                        newField[i][j] = ',';
                    }
                }
            }
        }
        for (int i = 0; i < newField.length; i++) {
            for (int j = 0; j < newField[i].length; j++) {
                System.out.print(newField[i][j]);
            }
            System.out.println();
        }
    }

}
