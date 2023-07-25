//Принцип Инверсии зависимостей - метод не наследуется от классе с конкретно прописанным методом swicth, а зависит от ин-
// терфейса, что делает его конструирование более гибким
public class NotificationsForXnO implements NotificatorConstructor{

    @Override
    public void notificationWithSwitch(int i) {
        switch (i) {
            case 0:
                System.out.println("Ходят нолики. Введите координаты:");
                break;
            case 1:
                System.out.println("Ходят крестики. Введите координаты:");
                break;
            case -1:
                System.out.println("Вы ввели координаты заполненой ячейка. Попробуйте снова");
                break;
            case 2:
                System.out.println("Победили крестики");
                break;
            case 3:
                System.out.println("Победили нолики");
                break;
        }

    }


}
