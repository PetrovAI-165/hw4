import java.util.List;
import java.util.Objects;

public class Transactions {
    static int idCounter=0;
    static private final List<String> directions = List.of("input","output");
    private String direction;
    private float cost;
    private int apartment;

    private int id;

    private static int newId(){
        idCounter++;
        return idCounter;
    }

    public Transactions(String direction, float cost,int apartment) throws Exception {
        if (!(directions.contains(direction))) {
            throw new Exception("Wrong value of direction");
        }
        this.direction = direction;
        this.cost = cost;
        this.apartment = apartment;
        this.id = newId();
    }

    public float getCost() {
        return this.cost;
    }

    public int getApartment() {
        return this.apartment;
    }

    public String getDirection() {
        return this.direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Float.compare(that.cost, cost) == 0 && apartment == that.apartment && id == that.id && direction.equals(that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, cost, apartment, id);
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "direction='" + direction + '\'' +
                ", cost=" + cost +
                ", apartment=" + apartment +
                ", id=" + id +
                '}';
    }
}
