//Принцип сегрегации интерфейсов - нам не нужен многофункциональный центр уведомлений, а достаточно одного метода-
// уведомления с переключателем

public interface NotificatorConstructor {

    void notificationWithSwitch(int i);

}
