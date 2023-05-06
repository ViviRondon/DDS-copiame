package ar.utn.dds.copiame;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AnalisisListController implements Handler {
    private AnalsisRepository repo;
    public AnalisisListController(AnalsisRepository repo) {
        super();
        this.repo = repo;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        ctx.json(repo.all());
    }
}
