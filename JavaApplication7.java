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
        int iteracijosCount = 0;

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

        while (arNeLygus(field, newField)) {
            if (iteracijosCount > 0) {
                field = arraySukeitimas(field, newField);
            }
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
                                    }
                                }
                            }
                            newField[i][j] = piesimas(xCount, field[i][j], false);
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
                            newField[i][j] = piesimas(xCount, field[i][j], true);
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
                            newField[i][j] = piesimas(xCount, field[i][j], false);
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
                            newField[i][j] = piesimas(xCount, field[i][j], false);
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
                            newField[i][j] = piesimas(xCount, field[i][j], true);
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
                            newField[i][j] = piesimas(xCount, field[i][j], false);
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
                            newField[i][j] = piesimas(xCount, field[i][j], false);

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
                            newField[i][j] = piesimas(xCount, field[i][j], true);
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
                            newField[i][j] = piesimas(xCount, field[i][j], false);
                        }
                    }
                }
            }
            iteracijosCount++;
            System.out.println();
            System.out.println();
            System.out.println();
        }

    }

    public static char piesimas(int xCount, char target, boolean arKampinis) {
        char kaimynas;
        if (target == 'X') {
            xCount--;
            if (xCount < 4 && xCount > 1) {
                kaimynas = 'X';
            } else {
                kaimynas = ',';
            }
        } else {
            if (xCount == 3) {
                kaimynas = 'X';
            } else {
                kaimynas = ',';
            }
        }
        System.out.print(kaimynas);
        if (arKampinis) {
            System.out.println();
        }
        return kaimynas;
    }

    //PALYGINIMAS SU PRIES TAI BUVUSIA
    static public boolean arNeLygus(char[][] field, char[][] newField) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != newField[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //ARRAY SUKEITIMAS, IGALINAMAS PRIES KIEVIENA CIKLA, PO PIRMOSIOS PARTIJOS;
    static public char[][] arraySukeitimas(char[][] field, char[][] newField) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = newField[i][j];
            }
        }
        return field;
    }
}
