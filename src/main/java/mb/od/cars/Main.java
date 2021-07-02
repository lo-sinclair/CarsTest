package mb.od.cars;

import mb.od.cars.xml.XMaster;

public class Main {
    public static void main(String[] args) {
        if( args.length > 0 && args[0].length() != 0 ) {
            String fileName = args[0];
            XMaster xMaster = new XMaster();
            int count = xMaster.countOfUniqueNames(fileName);

            System.out.println("Количество уникальных значений атрибута \"name\": " + count
                + "\nСпасибо, что были с нами в этот день :)");
        }
        else {
            System.out.println("Вы должны запустить приложение с параметром [имя файла]");
        }
    }
}
