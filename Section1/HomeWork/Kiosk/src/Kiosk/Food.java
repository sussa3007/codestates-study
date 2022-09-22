package CodeStates.Section1.HomeWork.Kiosk.src.Kiosk;

public abstract class Food{
    protected String name = "";
    protected int cost = 0;
    Food(){  }
    Food(String name, int cost) {
        setCost(cost);
        setName(name);
    }
    abstract public void setCost(int cost);
    abstract public int getCost();
    abstract public void setName(String name);
    abstract public String getName();
}
class Kimbap extends Food {
    Kimbap(String name, int cost) {
        super(name,cost);
    }

    @Override
    public void setCost(int cost) { super.cost = cost; }

    @Override
    public int getCost() { return cost; }

    @Override
    public void setName(String name) { super.name = name; }

    @Override
    public String getName() { return super.name; }
}
class EggKimbap extends Food {
    EggKimbap(String name, int cost) {
        super(name,cost);
    }

    @Override
    public void setCost(int cost) { super.cost = cost; }

    @Override
    public int getCost() { return cost; }

    @Override
    public void setName(String name) { super.name = name; }

    @Override
    public String getName() { return super.name; }
}
class ChungmuKimbap extends Food {
    ChungmuKimbap(String name, int cost) {
        super(name,cost);
    }

    @Override
    public void setCost(int cost) { super.cost = cost; }

    @Override
    public int getCost() { return cost; }

    @Override
    public void setName(String name) { super.name = name; }

    @Override
    public String getName() { return super.name; }
}
class Tteokbokki extends Food {
    Tteokbokki(String name, int cost) {
        super(name,cost);
    }

    @Override
    public void setCost(int cost) { super.cost = cost; }

    @Override
    public int getCost() { return cost; }

    @Override
    public void setName(String name) { super.name = name; }

    @Override
    public String getName() { return super.name; }
}
