package com.example.prestitiDependencies.bootstrap;


import com.example.prestitiDependencies.domain.Organizzazione;
import com.example.prestitiDependencies.domain.Rilevamento;
import com.example.prestitiDependencies.repositories.OrganizzazioneRepository;
import com.example.prestitiDependencies.repositories.RilevamentoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

@Component
public class BootstrapData implements CommandLineRunner {
    private final OrganizzazioneRepository organizzazioneRepository;
    private final RilevamentoRepository rilevamentoRepository;

    public BootstrapData(OrganizzazioneRepository organizzazioneRepository, RilevamentoRepository rilevamentoRepository) {
        this.organizzazioneRepository = organizzazioneRepository;
        this.rilevamentoRepository = rilevamentoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Organizzazione o1 = new Organizzazione();
        o1.setNome("Germania");
        //Organizzazione o1Saved = OrganizzazioneRepository.save(o1);
        Organizzazione o2 = new Organizzazione();
        o2.setNome("Spagna");
        Organizzazione o3 = new Organizzazione();
        o3.setNome("Francia");
        Organizzazione o4 = new Organizzazione();
        o4.setNome("Italia");
        Organizzazione o5 = new Organizzazione();
        o5.setNome("Olanda");
        Organizzazione o6 = new Organizzazione();
        o6.setNome("Euro zona");
        //Organizzazione[] mieOrg;
        //mieOrg = new Organizzazione[]{o1, o2, o3, o4, o5, o6};
        Organizzazione o1Saved = organizzazioneRepository.save(o1);
        Organizzazione o2Saved = organizzazioneRepository.save(o2);
        Organizzazione o3Saved = organizzazioneRepository.save(o3);
        Organizzazione o4Saved = organizzazioneRepository.save(o4);
        Organizzazione o5Saved = organizzazioneRepository.save(o5);
        Organizzazione o6Saved = organizzazioneRepository.save(o6);


        System.out.println(System.getProperty("user.dir"));
        String filePath = "C:\\Users\\EugenioScarafoni\\IdeaProjects\\prestiti_organizzazioni.csv";
        File CSVFile = new File(filePath);
        Scanner sc = new Scanner(CSVFile);
        sc.useDelimiter(";|\\n");
        String tempData = "";
        int c = 0;
        while (sc.hasNext())
        {
            if(c == 0) {
                tempData = sc.next();
                tempData = tempData.replace("\"", "");
            }
            else {
                Rilevamento r = new Rilevamento();
                r.setData(tempData);
                r.setImporto(Double.parseDouble(sc.next().replace("\"", "")));
                switch (c) {
                    case 1:
                        r.setOrganizzazione(o1);
                        break;
                    case 2:
                        r.setOrganizzazione(o2);
                        break;
                    case 3:
                        r.setOrganizzazione(o3);
                        break;
                    case 4:
                        r.setOrganizzazione(o4);
                        break;
                    case 5:
                        r.setOrganizzazione(o5);
                        break;
                    case 6:
                        r.setOrganizzazione(o6);
                        break;
                }
                Rilevamento rSaved = rilevamentoRepository.save(r);
            }

            if(c<6) {
                c++;
            }
            else {
                c = 0;
            }

            //System.out.print(sc.next() + " | ");
        }
        sc.close();
    }
}

