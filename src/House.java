import java.util.*;

import static java.lang.Math.abs;

public class House {
    //key : apartments number, value: apartments owner
    Map<Integer,Tenant> apartments;
    List<ServiceStaff> staff;
    Set<Transactions> transactions;

    public House(Map<Integer, Tenant> apartments, List<ServiceStaff> staff, Set<Transactions> transactions) {
        this.apartments = apartments;
        this.staff = staff;
        this.transactions = transactions;
    }

    //just for comfortable datasetup
    public House() throws Exception {
        //Data setup
        this.apartments = new HashMap<Integer,Tenant>();
        this.apartments.put(1,new Tenant("Vasilii","Ivanov",32));
        this.apartments.put(2,new Tenant("Sergey","Petrov",25));
        this.apartments.put(3,new Tenant("Viktor","Sydorov",26));
        this.apartments.put(4,new Tenant("Alexey","Alexeev",72));
        this.apartments.put(5,new Tenant("Petr","Spiridonov",22));
        this.staff = new ArrayList<ServiceStaff>();
        this.staff.add(new ServiceStaff("plumber","VItaliy","Orlov",21,20000));
        this.staff.add(new ServiceStaff("cleaner","Ignat","Svetlov",21,15000));
        this.staff.add(new ServiceStaff("electrecian","Boris","Ulianov",21,25000));
        this.transactions = new HashSet<>();
    }

    public List<ServiceStaff> getStaff() {
        return this.staff;
    }

    public Map<Integer, Tenant> getApartments() {
        return this.apartments;
    }

    public Set<Transactions> getTransactions() {
        return this.transactions;
    }

    public int getAppartmentBalance(int appId){
        int result =0;
        for (Transactions t: this.transactions) {
            if(t.getApartment()==appId){
                if(t.getDirection().toLowerCase()=="input"){
                    result -= t.getCost();
                }else{
                    result += t.getCost();
                }
            }
        }
        return result;
    }

    public int getHouseBalance(){
        int result = 0;
        for (Transactions t: this.transactions) {
            if(t.getDirection().toLowerCase()=="input"){
                result -= t.getCost();
            }else{
                result += t.getCost();
            }
        }
        return result;
    }

    public void sendCheck(int apId, int sum) throws Exception {
        transactions.add(new Transactions("input",sum,apId));
    }

    public void takePayment(int apId, int sum) throws Exception {
        int appBalance = getAppartmentBalance(apId);
        if(sum>abs(appBalance)){
            throw new Exception("Too much");
        }
        this.transactions.add(new Transactions("output",sum,apId));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return apartments.equals(house.apartments) && staff.equals(house.staff) && transactions.equals(house.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartments, staff, transactions);
    }
}
