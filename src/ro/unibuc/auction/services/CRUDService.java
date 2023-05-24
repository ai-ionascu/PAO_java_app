package ro.unibuc.auction.services;
import java.util.List;

public interface CRUDService<Ob> {
    void create(Ob object);
    List<Ob> read();
    void update(Ob oldObject, Ob newObject);
    void delete(Ob object);
}
