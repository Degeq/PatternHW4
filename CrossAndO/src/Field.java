import java.util.Scanner;

//Принцип Барбары Лисков - создание общего класса "Field" и для Крестиков-Ноликов, и для Морского боя, например,
// не имело бы смысла, поскольку единственное свойство, которое оба поля наследуют - квадратная размерность, при этом
// методы ходов и заполнения поля кардинально отличаются

public class Field {

    //Magics
    private static final char EMPTY = '-';
    private static final char CROSS = 'X';
    private static final char ZERO = 'O';
    private static final int ERRORCode = -1;
    private static final int CrossWinner = 2;
    private static final int OWinner = 3;


    private int size;
    private char[][] field;
    private int moveCounter = 1;
    private NotificationsForXnO notificator = new NotificationsForXnO();
    private Scanner scanner = new Scanner(System.in);

    public Field(int size) {
        this.size = size;
        this.field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = '-';
            }
        }
    }

    public boolean move() {
        String coordinates = null;
        int x = 0;
        int y = 0;

        switch (moveCounter % 2) {
            case 1:
                notificator.notificationWithSwitch(moveCounter % 2);
                coordinates = scanner.nextLine();
                String[] parts = coordinates.split(" ");
                x = Integer.parseInt(parts[0]) - 1;
                y = Integer.parseInt(parts[1]) - 1;

                if (field[x][y] != EMPTY) {
                    notificator.notificationWithSwitch(ERRORCode);
                } else {
                    field[x][y] = CROSS;
                    outputField();
                    moveCounter++;
                }
                break;
            case 0:
                notificator.notificationWithSwitch(moveCounter % 2);

                coordinates = scanner.nextLine();
                String[] parts1 = coordinates.split(" ");
                x = Integer.parseInt(parts1[0]) - 1;
                y = Integer.parseInt(parts1[1]) - 1;

                if (field[x][y] != EMPTY) {
                    notificator.notificationWithSwitch(ERRORCode);
                } else {
                    field[x][y] = ZERO;
                    outputField();
                    moveCounter++;
                }
                break;
            default:
                break;
        }

        if (isPlayerWinner()) {
            if (field[x][y] == CROSS) {
                notificator.notificationWithSwitch(CrossWinner);
            } else {
                notificator.notificationWithSwitch(OWinner);
            }
            return false;
        } else {
            return true;
        }
    }

    //единственная ответственность - метод только выводит поле на экран, не нагружая метода хода или определения победителя
    //неповторение кода
    public void outputField() {
        for (char[] raw : field) {
            for (char cell : raw) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private boolean isPlayerWinner() {
        boolean winner = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1); j++) {
                winner = (field[i][j] == field[i][j + 1] && field[i][j + 1] != EMPTY);
                if (winner == false) {
                    break;
                }
            }
            if (winner) {
                return winner;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1); j++) {
                winner = ((field[j][i] == field[j + 1][i]) && field[j + 1][i] != EMPTY);
                if (winner == false) {
                    break;
                }
            }
            if (winner) {
                return winner;
            }
        }
        for (int i = 0; i < (size - 1); i++) {
            winner = ((field[i][i] == field[i + 1][i + 1]) && field[i + 1][i + 1] != EMPTY);
            if (winner == false) {
                break;
            }
        }
        if (winner) {
            return winner;
        }
        for (int i = (size - 1); i > 0; i--) {
            winner = ((field[i][size - i - 1] == field[i - 1][size - i]) && field[i - 1][size - i] != EMPTY);
            if (winner == false) {
                break;
            }
        }
        return winner;
    }

}
