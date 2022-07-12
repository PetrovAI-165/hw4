import org.w3c.dom.html.HTMLHeadElement;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        House house = new House();
        house.sendCheck(1,2000);
        house.sendCheck(2,2400);
        house.sendCheck(3,2122);
        house.sendCheck(4,2121);
        house.sendCheck(5,2131);

        house.takePayment(1,1500);
        house.takePayment(2,200);

        System.out.println(house.getAppartmentBalance(1));
        System.out.println(house.getAppartmentBalance(2));
        System.out.println(house.getHouseBalance());


        System.out.println(house.getStaff().toString());
        house.setSalaryForEmployee(50000,"Ihor","Sverlov");
        System.out.println(house.getStaff().toString());
        house.setSalaryForStaffbyTitle(35000,"cleaner");
        System.out.println(house.getStaff().toString());

        System.out.println(house.getApartments());
        house.changeApOwner(1,new Tenant("Ivan","Groznyi",110));
        System.out.println(house.getApartments());
        house.moveAllTenantToNextApp();
        System.out.println(house.getApartments());
    }
}