package org.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.function.Function;

@Controller
public class PlotController {
    @Value(value = "classpath:plot.R")
    private Resource rSource;

    @Autowired
    private Context context;

    @Autowired
    private Function<DataHolder, String> plotFunction;

    @Autowired
    private CSVReader csvReader;

    private int counter = 0; // Satır numarasını takip etmek için sayaç

    @Bean
    public Function<DataHolder, String> getPlotFunction(@Autowired Context ctx) throws IOException {
        Source source = Source.newBuilder("R", rSource.getURL()).build();
        return ctx.eval(source).as(Function.class);
    }

    @RequestMapping(value = "/plot", produces = "image/svg+xml")
    public ResponseEntity<String> load() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Refresh", "1");

        String svg = "";
        try {
            Double value = csvReader.getNextValue(); // Sıradaki değeri al
            if (value != null) {
                counter++;  // Sayaç bir artırılıyor
                System.out.println("row" + counter + " -> " + value);

                synchronized (plotFunction) {
                    // R fonksiyonuna "row" + counter ve değeri gönderiyoruz
                    svg = plotFunction.apply(new DataHolder("row" + counter, value));
                }
            } else {
                System.out.println("CSV dosyasında okunacak daha fazla veri yok.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(svg, responseHeaders, HttpStatus.OK);
    }

    @Bean
    public Context getGraalVMContext() {
        return Context.newBuilder().allowAllAccess(true).build();
    }
}
