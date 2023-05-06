package ar.utn.dds.copiame;

import io.javalin.Javalin;

public class CopiameAPI {
    public static void main(String[] args) {

        Integer port = Integer.parseInt( System.getProperty("port", "8080"));
        Javalin app = Javalin.create().start(port);
        AnalsisRepository repo = new AnalsisRepository();

        app.get("/analisis", new AnalisisListController(repo));
        app.post("/analisis", new AnalisisAddController(repo));
/*
app.get("/revisor/{id}/revision",
new RevisorRevisionesListController(repo));
app.post("/revisor/{id}/revision",
new RevisorAddRevisionController(repo));
app.get("/revisor/{id}/revision/{rev}/file/{fileid}",
new RevisorRevisionFilesController(repo));
*/
    }
}
