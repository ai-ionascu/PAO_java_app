package ro.unibuc.auction.services;
import java.util.List;

public interface CRUDService<Ob> {
    void create(Ob object);
    List<Ob> read();
    void update(Ob object);
    void delete(Ob object);
}
