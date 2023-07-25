import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new Field(3);
        System.out.println("Привет! Это игра в крестики нолики - для совершения хода введите координаты клетки, " +
                "в которую хотите поставить Ваш знак через пробел, вот так: '1 1'");

        while (field.move()) {

        }


    }

}


