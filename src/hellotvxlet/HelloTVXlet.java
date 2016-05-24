package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.ui.DVBColor;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;

public class HelloTVXlet implements Xlet, HActionListener, ResourceClient, HBackgroundImageListener {

    private HScene scene;
    private HScreen screen;    
    private HBackgroundDevice bgDevice;    
    private HStillImageBackgroundConfiguration bgConfig;    
    private HBackgroundImage schoolbord = new HBackgroundImage("schoolbord.m2v"); 
    private HStaticText vraag;
    private HTextButton optie1, optie2, optie3, optie4, optie5, optie6, volgende;
    private int score = 0; //score in int
    private String scoreString; //score (int) als string
    private HStaticText tekstScore; //Score (int) als HstaticText
    private String punten = "Punten: "; //woord Punten
    private HStaticText tekstPunten; //woord Punten in HstaticText
    private HStaticText titel;
    private HStaticText vraagTekst;
    private int vraagNummer = 1;
    private String vraagNummerString;
    private HStaticText tekstVraagNummer;
    private HStaticText result = new HStaticText("",100,450,300,45);
    private HTextButton juisteOptie;
    private HStaticText EindeSpel = new HStaticText("Het Spel is gedaan! Check je score bovenaan.", 110, 250, 500, 45);
    
    
     
    // backgroudn img --> schoolbord toevoegen
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
        scene = HSceneFactory.getInstance().getDefaultHScene();     
        
        screen = HScreen.getDefaultHScreen();        
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        bgDevice.reserveDevice(this);
        
        //boolean gereserveerd = bgDevice.reserveDevice(this); 
        

        //configuratie
        HBackgroundConfigTemplate bgConfigTemplate = new HBackgroundConfigTemplate();  
        bgConfigTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE,                 
                HBackgroundConfigTemplate.REQUIRED);  
        
        bgConfig = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgConfigTemplate);
        
        try 
        {            
            bgDevice.setBackgroundConfiguration(bgConfig);        
        } 
        
        catch (Exception ex) 
        {            
       
            ex.printStackTrace();        
        
        } 
        
        
 

        
    }
    
    
    
    public void imageLoaded(HBackgroundImageEvent e) 
    {   
        
        System.out.println("Image geladen");
        
        try 
        {            
            bgConfig.displayImage(schoolbord);        
        } 
        
        catch (Exception ex) 
        {            
            ex.printStackTrace();        
        } 
        
        
    }
    
    public void imageLoadFailed(HBackgroundImageEvent e) 
    {        
        
        System.out.println("Image mislukt");
        
    } 
    
    
    

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
        
        schoolbord.load(this);
        
        
        titel= new HStaticText("English Quiz", 270, 50, 200, 50);
        
        vraagTekst= new HStaticText("Vraag     :", 92, 90, 100, 50);
        
        scoreString = Integer.toString(score);
        
        tekstScore = new HStaticText(scoreString, 555, 0, 150, 150);
        
        vraagNummerString = Integer.toString(vraagNummer);
        
        tekstVraagNummer = new HStaticText(vraagNummerString, 120, 90, 100, 50);
        
        

       //aanmaken van vraag
        vraag = new HStaticText("Wat is de correcte vertaling van 'vanzelfsprekend'?", 50, 150, 600, 50);
        
        
        tekstPunten = new HStaticText(punten, 320,58,300,300);
        tekstPunten.setVerticalAlignment(tekstPunten.VALIGN_TOP); 
        tekstPunten.setHorizontalAlignment(tekstPunten.HALIGN_RIGHT); 
        
        
        //aanmaken van opties van anwtoorden
        optie1 = new HTextButton("Ofcourse", 105, 210, 200, 50);
        optie1.setBackground(new DVBColor(255,255,255,100));
        optie1.setActionCommand("foute geselecteerd");//deze string word naar object actionlistner gestuurd
        optie1.addHActionListener(this); //voeg HActionleistener toe bij implements bovenaan
        
        optie2 = new HTextButton("Of caurse", 395, 210, 200, 50);
        optie2.setBackground(new DVBColor(255,255,255,100));
        optie2.setActionCommand("foute geselecteerd");
        optie2.addHActionListener(this);
        
        
        optie3 = new HTextButton("Offcourse", 105, 285, 200, 50);
        optie3.setBackground(new DVBColor(255,255,255,100));
        optie3.setActionCommand("foute geselecteerd");
        optie3.addHActionListener(this);
        
        
        optie4 = new HTextButton("Off course", 395, 285, 200, 50);
        optie4.setBackground(new DVBColor(255,255,255,100));
        optie4.setActionCommand("foute geselecteerd");
        optie4.addHActionListener(this);
        
        
        optie5 = new HTextButton("Of course", 105, 360, 200, 50);
        optie5.setBackground(new DVBColor(255,255,255,100));
        optie5.setActionCommand("juiste geselecteerd");
        optie5.addHActionListener(this);
        
        optie6 = new HTextButton("Ofcaurse", 395, 360, 200, 50);
        optie6.setBackground(new DVBColor(255,255,255,100));
        optie6.setActionCommand("foute geselecteerd");
        optie6.addHActionListener(this);
        
        
        juisteOptie = optie5;
        
        
        // aanmaken van 'volgende' knop
        volgende = new HTextButton("Volgende >>", 485, 450, 150, 45);
        volgende.setBackground(new DVBColor(255,255,255,100));
        volgende.setActionCommand("volgende geselecteerd");
        volgende.addHActionListener(this);
        
        
        
        
        //Vastleggen voor pijltjes waar de andere knopppen staan (boven, onder, links, rechts
        optie1.setFocusTraversal(null, optie3, null, optie2);
        optie2.setFocusTraversal(null, optie4, optie1, null);
        optie3.setFocusTraversal(optie1, optie5, null, optie4);
        optie4.setFocusTraversal(optie2, optie6, optie3, null);
        optie5.setFocusTraversal(optie3, null, null, optie6);
        optie6.setFocusTraversal(optie4, null, optie5, null);
       
      
        
        // toevoegen van knoppen
        scene.add(titel);
        
        scene.add(vraagTekst);
        
        scene.add(vraag);
        
        scene.add(tekstVraagNummer);
        
        scene.add(tekstPunten);
        
        scene.add(tekstScore);
        
        scene.add(optie1);
        scene.add(optie2);
        scene.add(optie3);
        scene.add(optie4);
        scene.add(optie5);
        scene.add(optie6);

        
        
        scene.validate();
        scene.setVisible(true);
        //als eerste op gefocust/gehighlighed
        optie1.requestFocus();
        
    }
    
    
    
    public void actionPerformed(ActionEvent event) {
    
        //System.out.println(event.getActionCommand()); //string ophalen en tonen
        if (event.getActionCommand().equals("juiste geselecteerd")) {
            
            result.setTextContent("Proficiat! Je antwoord is correct!", HVisible.NORMAL_STATE); //vanaf links, vanaf boven, breedte, hoogte
            result.setForeground(Color.GREEN);
            scene.add(result);
            scene.popToFront(result);
            
            //bij eerste vraag = bv al 1 punt 
            score++;
            System.out.println(score);
            
            tekstScore.setTextContent(String.valueOf(score), HVisible.NORMAL_STATE);
            
            
            //refreshed je scherm
            scene.repaint();
            
           
            
            
        }
        
        //Als u antwoord fout is
        else {
            
            result.setTextContent("Oops! Je antwoord is incorrect!", HVisible.NORMAL_STATE);
            result.setForeground(Color.RED);
            scene.add(result);
            scene.popToFront(result);
            scene.repaint();
            
            
            
        }
        
        //highlighten van het juiste antwoord
        juisteOptie.setBackground(Color.GREEN);
        scene.add(volgende);
        
        //zodat je direct na je juiste/foute antwoord door kan klikken naar de volgende vraag
        volgende.requestFocus();
        
        if (event.getActionCommand().equals("volgende geselecteerd")) {
            
            
        
            if(vraagNummer < 10) {
                
                
                vraagNummer++;
                System.out.println(vraagNummer);

                tekstVraagNummer.setTextContent(String.valueOf(vraagNummer), HVisible.NORMAL_STATE);

                optie1.requestFocus();

                result.setTextContent("", HVisible.NORMAL_STATE);
                
                juisteOptie.setBackground(Color.WHITE);
            
            }
            
            
            else if(vraagNummer == 10){
                
                scene.remove(vraagTekst);
        
                scene.remove(vraag);

                scene.remove(tekstVraagNummer); 

                scene.remove(optie1);
                scene.remove(optie2);
                scene.remove(optie3);
                scene.remove(optie4);
                scene.remove(optie5);
                scene.remove(optie6);
                scene.remove(result);
                scene.remove(volgende);
                
                
                scene.add(EindeSpel);
                
                
                
            }






























if(vraagNummer == 2) {
                
                
                vraag.setTextContent("Wat is een synoniem voor contemplate?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("ponder", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("juiste geselecteerd");
                optie2.setTextContent("merit", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("depict", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("atone", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("create", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("despite", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie1;
                
            
            }
            
            
            
            if(vraagNummer == 3) {
                
                
                vraag.setTextContent("Wat is het  omgekeerde van pretentious?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("substantive", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("modest", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("juiste geselecteerd");
                optie3.setTextContent("suave", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("spurious", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("conspicuous", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("flaunty", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie2;
                
            
            }
            
            
            
            
            if(vraagNummer == 4) {
                
                
                vraag.setTextContent("Wat is precipitation?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("specifiek", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("uitkomst", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("voorbedacht", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("zonlicht", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("neerslag", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("juiste geselecteerd");
                optie6.setTextContent("doordacht", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie5;
                
            
            }
            
            
            
            
            if(vraagNummer == 5) {
                
                
                vraag.setTextContent("Wat is een vertaling van billowing?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("stormy", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("juiste geselecteerd");
                optie2.setTextContent("insensate", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("lackluster", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("pandemic", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("fly", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("attack", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie1;
                
            
            }
            
            
            
            
            if(vraagNummer == 6) {
                
                
                vraag.setTextContent("Wat is een synoniem voor attainable?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("rekening houden", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("onvoorspelbaar", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("voorbedacht", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("berekend", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("vergezocht", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("haalbaar", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("juiste geselecteerd");
                
                juisteOptie = optie6;
                
            
            }
            
            
            
            
            
            if(vraagNummer == 7) {
                
                
                vraag.setTextContent("Wat is een synoniem voor sturdy?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("hevig", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("slordig", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("onbetrouwbaar", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("stevig", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("juiste geselecteerd");
                optie5.setTextContent("stomp", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("kalm", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie4;
                
            
            }
            
            
            
            if(vraagNummer == 8) {
                
                
                vraag.setTextContent("Wat is een synoniem voor scarcely?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("probably", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("very low", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("almost not", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("juiste geselecteerd");
                optie4.setTextContent("describe", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("smoothly", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("openly", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie3;
                
            
            }
            
            
            
            if(vraagNummer == 9) {
                
                
                vraag.setTextContent("Wat is een synoniem voor enhance?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("beheksen", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("verbeteren", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("juiste geselecteerd");
                optie3.setTextContent("verlagen", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("bezwering", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("foute geselecteerd");
                optie5.setTextContent("kansloos", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("goed geluk", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie2;
                
            
            }
            
            
            
            
            if(vraagNummer == 10) {
                
                
                vraag.setTextContent("Wat is een synoniem voor retrieve?", HVisible.NORMAL_STATE);
                
                optie1.setTextContent("evaporate", HVisible.NORMAL_STATE);
                    optie1.setActionCommand("foute geselecteerd");
                optie2.setTextContent("refute", HVisible.NORMAL_STATE);
                    optie2.setActionCommand("foute geselecteerd");
                optie3.setTextContent("maneuver", HVisible.NORMAL_STATE);
                    optie3.setActionCommand("foute geselecteerd");
                optie4.setTextContent("recover", HVisible.NORMAL_STATE);
                    optie4.setActionCommand("juiste geselecteerd");;
                optie5.setTextContent("break up", HVisible.NORMAL_STATE);
                    optie5.setActionCommand("foute geselecteerd");
                optie6.setTextContent("calm down", HVisible.NORMAL_STATE);
                    optie6.setActionCommand("foute geselecteerd");
                
                juisteOptie = optie4;
                
            
            }
            
            
            
            scene.repaint();
        }
        
        
        
        
        
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        return false;
    }

    public void release(ResourceProxy proxy) {
        
    }

    public void notifyRelease(ResourceProxy proxy) {
        
    }

 
}