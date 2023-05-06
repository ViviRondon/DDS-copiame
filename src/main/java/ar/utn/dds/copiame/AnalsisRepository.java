package ar.utn.dds.copiame;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AnalsisRepository {
    private Map<String,AnalsisDeCopia> lista;
    public AnalsisRepository() {
        super();
        this.lista = new HashMap<String, AnalsisDeCopia>();
    }
    public void save(AnalsisDeCopia analisis) {
        String key = UUID.randomUUID().toString().substring(0, 5);
        analisis.setId(key);
        this.lista.put(key, analisis);
    }
    public AnalsisDeCopia findById(String id) {
        return this.lista.get(id);
    }
    public Collection<AnalsisDeCopia> all() {
        return this.lista.values();
    }
}

