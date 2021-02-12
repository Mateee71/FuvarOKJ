package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FuvarProgram {
    
    
    public static void main(String[] args) throws IOException {
        
        List<String> sorok = Files.readAllLines(Paths.get("fuvar.csv"));
        ArrayList<Fuvar> fuvarok = new ArrayList<>();
        
        for (int i = 1; i < sorok.size(); i++) {
            fuvarok.add(new Fuvar(sorok.get(i)));
        }
        
        System.out.print("3. feladat: ");
        int fuvarDb = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            fuvarDb++;
        }
        System.out.println(fuvarDb + " fuvar");
        
        System.out.print("4. feladat: ");
        fuvarDb = 0;
        double osszesen = 0.0;
        for (Fuvar fuvar : fuvarok) {
            if (fuvar.getTaxi_id() == 6185) {
                fuvarDb++;
                osszesen += fuvar.getViteldij();
            }
        }
        System.out.printf("%d fuvar alatt: %.2f$\n",fuvarDb, osszesen);
        
        
        
    }
    
}
