package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        
        System.out.print("5. feladat: \n");
        HashMap<String, Integer> fiz_modok = new HashMap<>();
        for (Fuvar fuvar : fuvarok) {
            String kulcs = fuvar.getFizetes_modja();
            if (!fiz_modok.containsKey(kulcs)) {
                fiz_modok.put(kulcs, 1);
            }else{
                int ertek = fiz_modok.get(kulcs);
                fiz_modok.put(kulcs, ++ertek);
            }
        }
        
        for (Map.Entry<String, Integer> entry : fiz_modok.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("\t%7s: %d fuvar\n",key, value);
        }
        
         System.out.print("6. feladat: ");
        double osszMegtett = 0.0;
        for (Fuvar fuvar : fuvarok) {
            osszMegtett += fuvar.getTavolsag();
        }
        System.out.printf("%.2fkm\n",(osszMegtett * 1.6));
        
        
    }
    
}
