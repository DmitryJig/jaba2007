package course1.lesson2;

public class SwitchApp {
    public static void main(String[] args) {
            checkOrderStatus2("ACCEPTED");
            checkOrderStatus2("IN DELIVERY");

    }

    public static void checkOrderStatus(String orderStatus) {
        if (orderStatus.equals("ACCEPTED")) {
            System.out.println("принят");
        } else if (orderStatus.equals("DELIVERED")) {
            System.out.println("Доставлен");
        } else {
            System.out.println("Неизвестный статус заказа");
        }
    }

    public static void checkOrderStatus2(String orderStatus) {
        switch (orderStatus) {
            case "ACCEPTED" : {
                System.out.println("Принят");
                break;
            }
            case "DELIVERED" : {
                System.out.println("Доставлен");
                break;
            }
            default: {
                System.out.println("Неизвестный статус заказа");
            }
        }
    }
}
