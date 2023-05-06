package ar.utn.dds.copiame;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisisAddController implements Handler {
    private AnalsisRepository repo;
    public AnalisisAddController(AnalsisRepository repo) {
        super();
        this.repo = repo;
    }
    @Override
    public void handle(Context ctx) throws Exception {
// Proceso de parámetros de entrada
        String destDirectory = "src/test/resources/lote1";
        UnzipUtility.unzip(ctx.uploadedFile("file").content()
                ,destDirectory);

// Armado del Análisis
        Lote lote = new Lote(destDirectory);
        lote.validar();
        lote.cargar();
        float umbral = 0.5f;
        AnalsisDeCopia analisis =
                new AnalsisDeCopia(umbral, lote);
        analisis.addEvaluador(new EvaluadorDeCopiaAutomatico());
        Revisor revisor = new Revisor();
        List<Revisor> revisores = Arrays.asList(revisor);
        EvaluadorDeCopiaManual eval =
                new EvaluadorDeCopiaManual(revisores,1.0);
        analisis.addEvaluador(eval);

// Proceso del lote
        analisis.procesar();
// Guardar
        repo.save(analisis);

// Armado de la respuesta
        Map<String,String> rta = new HashMap<String, String>();
        rta.put("analisis", analisis.getId());
        ctx.json(rta);
    }
}
