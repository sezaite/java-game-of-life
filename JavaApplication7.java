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

        //PIRMINES KAIMINYSTES ISPIESIMAS:
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
        
        System.out.println();
        System.out.println();
        System.out.println();

        //KAIMYNU SKAICIAVIMAS, KRASTINIU GYVENTOJU VALIDACIJOS:
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if (i == 0) { //PIRMOS EILUTES KAIMYNAI
                    if (j == 0) {
                        //pirmas kampinis pirmos eilutes elementas;
                        int xCount = 0;
                        for (int k = i; k < i + 2; k++) {
                            for (int l = j; l < j + 2; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                    System.out.println(xCount);
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], false);
                    } else if (j == field[i].length - 1) {
                        //pirmos eilutes paskutinis kampinis elementas;
                        int xCount = 0;
                        for (int k = i; k < i + 2; k++) {
                            for (int l = j - 1; l < j + 1; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], true);
                    } else {
                        //pirmos eilutes vidurinieji elementai
                        int xCount = 0;
                        for (int k = i; k < i + 2; k++) {
                            for (int l = j - 1; l < j + 2; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], false);
                    }

                    //PASKUTINES EILUTES KAIMYNAI
                } else if (i == field.length - 1) {
                    if (j == 0) {
                        //pirmas kampinis paskutines eilutes elementas;
                        int xCount = 0;
                        for (int k = i - 1; k < i + 1; k++) {
                            for (int l = j; l < j + 2; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], false);
                    } else if (j == field[i].length - 1) {
                        //paskutines eilutes paskutinis kampinis elementas;
                        int xCount = 0;
                        for (int k = i - 1; k < i + 1; k++) {
                            for (int l = j - 1; l < j + 1; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], true);
                    } else {
                        //paskutines eilutes vidurinieji elementai
                        int xCount = 0;
                        for (int k = i - 1; k < i + 1; k++) {
                            for (int l = j - 1; l < j + 2; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], false);
                    }
                } else { //VIDURINIUJU EILUCIU KAIMYNAI
                    if (j == 0) {
                        //viduriniuju eiluciu pirmieji elementai
                        int xCount = 0;
                        for (int k = i - 1; k < i + 2; k++) {
                            for (int l = j; l < j + 2; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], false);

                    } else if (j == field[i].length - 1) {
                        //viduriniuju eiluciu paskutiniai elementai
                        int xCount = 0;
                        for (int k = i - 1; k < i + 2; k++) {
                            for (int l = j - 1; l < j + 1; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], true);
                    } else {
                        //viduriniuju eiluciu vidurinieji elementai
                        int xCount = 0;
                        for (int k = i - 1; k < i + 2; k++) {
                            for (int l = j - 1; l < j + 2; l++) {
                                if (field[k][l] == 'X') {
                                    xCount++;
                                }
                            }
                        }
                        piesimas(i, j, xCount, field[i][j], false);
                    }
                }
            }
        }
    }

    public static void piesimas(int i, int j, int xCount, char target, boolean lineBreak) {
        char[][] newField = new char[50][50];
        if (target == 'X') {
            if (xCount < 4 && xCount > 1) {
                newField[i][j] = 'X';
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
        System.out.print(newField[i][j]);
        if (lineBreak) {
            System.out.println();
        }
        return;
    }
}
