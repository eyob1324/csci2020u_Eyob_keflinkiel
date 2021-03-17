package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFile {
   private String filename;
   private int Flasfloodcounter;
   private int thunderStormCounter;
   private  int specialMarineCounter;
   private  int TornadoCounter;

   LoadFile(String filename){
       this.filename = filename;
       this.Flasfloodcounter =0;
        this.thunderStormCounter =0;
        this.specialMarineCounter = 0;
        this.TornadoCounter =0;
   }

   public void Load(){
       String line = "";

       try{
           BufferedReader reader = new BufferedReader(new FileReader(this.filename));
           while ((line = reader.readLine()) != null){
                String[] columns = line.split(",");
                for(String column: columns){
                    if(column.toString().equals("FLASH FLOOD")){
                        this.Flasfloodcounter = this.Flasfloodcounter+1;
                    }
                    if(column.toString().equals("TORNADO")){
                        this.TornadoCounter = this.TornadoCounter+1;
                    }
                    if(column.toString().equals("SEVERE THUNDERSTORM")){
                        this.thunderStormCounter = this.thunderStormCounter+1;
                    }
                    if(column.toString().equals("SPECIAL MARINE")){
                        this.specialMarineCounter = this.specialMarineCounter+1;
                    }


                }
           }
       }catch (FileNotFoundException e){
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public int getFlasfloodcounter(){
       return this.Flasfloodcounter;
   }

   public int getThunderStormCounter(){
       return this.thunderStormCounter;
   }

   public int getSpecialMarineCounter(){
       return  this.specialMarineCounter;
   }

   public int getTornadoCounter(){
       return this.specialMarineCounter;
   }


}
