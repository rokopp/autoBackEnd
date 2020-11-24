package b_theory.question11;

public class Nr4isI {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does I stand for in SOLID? Explain the principle.
    //todo Interface segregation principle states that no client should be forced to depend on methods it does not use.
    //todo B Give an example. Write actual or pseudo code.
}

//todo SportsCars interface is an interface with some actions of an sports car.
interface SportsCars {

    void race();

    void drifting();

    void dragRacing();

    void formula();

}

//todo Ott Tänak is a rally driver.
// By implementing the SportsCars interface we have to implement methods like dragRacing and formula which OttT2nak will never use.
class OttT2nak implements SportsCars {

    @Override
    public void race() {
        System.out.println("Ott Tänak started racing");
    }

    @Override
    public void drifting() {
        System.out.println("Ott Tänak went sideways and its called drifting");
    }

    @Override
    public void dragRacing() {
    }

    @Override
    public void formula() {
    }
}

//todo same problems occur like for OttT2nak, where some methods aren't used
interface DriftCar extends SportsCars {

    void drifting();

}

//todo same problems occur like for OttT2nak, where some methods aren't used
interface KimiRaikonen extends SportsCars {

    void dragRacing();

    void formula();

}

//todo Therefore Ott Tänak will not have to implement actions that he is not capable of performing.
abstract class OttT2nak2 implements DriftCar {

    @Override
    public void race() {
        System.out.println("Ott Tänak started racing");
    }

    @Override
    public void drifting() {
        System.out.println("Ott Tänak went sideways and its called drifting");
    }

}

