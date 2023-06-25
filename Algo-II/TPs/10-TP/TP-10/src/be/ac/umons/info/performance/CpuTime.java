package be.ac.umons.info.performance;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
  La classe CpuTime permet le calcul du temps depense par le processeur
  (temps CPU) pour executer le thread courant (et independemment des autres
  processus trounant sur la machine).

  Elle fonctionne comme un chronometre qui possederait deux boutons et
  un cadran:
    - le bouton "start" permet de mettre le chronometre en marche
    - le bouton "stop" arrete le chronometre
    - on peut ensuite lire sur le cadran le temps ecoulé entre l'utilisation
      de ces deux boutons.

  Il convient donc de l'utiliser correctement en utilisant toujours "start",
  puis "stop" avant d'utiliser une des methodes accessors permettant de
  connaitre le temps CPU.

  Par exemple:
        CpuTime time = new CpuTime();
        time.start();
        // Opérations dont on veut mesurer le temps.
        time.stop();
        System.out.println(time.getTime());

  Merci a R. Absil (BAC2 Math) pour les indications concernant la classe
  ThreadMXBean.

  @author H. Melot
*/


public class CpuTime
{
    private long nanoStart;
    private ThreadMXBean thd;
    private long previousTime;
    private long currentTime;

    /**
       Construit un CpuTime
     */
    public CpuTime()
    {
        nanoStart = 0L;
        thd = ManagementFactory.getThreadMXBean();
        previousTime = 0L;
        currentTime = 0L;
    }

    /**
       Demarre le "chronometre"
    */
    public void start()
    {
        nanoStart = thd.getCurrentThreadUserTime();
    }

    /**
       Arrete le "chronometre"
    */
    public void stop()
    {
        long nanoStop = thd.getCurrentThreadUserTime();
        previousTime = currentTime;
        currentTime = nanoStop - nanoStart;
    }

    /**
       Retourne le temps CPU (en sec.) ecoule entre les deux derniers
       appels a "start" suivi de "stop".

       @return le temps CPU ecoule (en secondes)
    */
    public double getSeconds()
    {
        return (currentTime) / 1E9;
    }

    /**
       Retourne le temps CPU ecoule entre les deux derniers
       appels a "start" suivi de "stop". La valeur retournee est exprimee
       en millieme de secondes et est arrondie au millieme de seconde le
       plus proche.

       @return le temps CPU ecoule (en milliemes de secondes)
    */
    public long getMilliSeconds()
    {
        return Math.round((currentTime) / 1E6);
    }

    /**
       Retourne le temps CPU (en nano sec. = 1OE-9 sec) ecoule entre les
       deux derniers appels a "start" suivi de "stop".

       @return le temps CPU ecoule (en nano secondes)
    */
    public long getNanoSeconds()
    {
        return currentTime;
    }

    /**
       Retourne le temps CPU ecoule entre les deux derniers
       appels a "start" suivi de "stop" sous la forme d'une
       chaine de characteres du type "3 hours 24 min 3 sec 234 ms"

       @return le temps CPU ecoule (format texte)
    */
    public String getTime()
    {
        long rest = getMilliSeconds();
        long ms = rest % 1000;
        rest = rest / 1000; // expressed in sec
        String time = ms + " ms";

        String[] unit = {"sec", "min", "hours"};
        long[] val = {60, 60, 24};

        for (int i = 0; i < unit.length && rest > 0; i++)
        {
            long t = rest % val[i];
            rest = rest / val[i];
            time = t + " " + unit[i] + " " + time;
        }

        if (rest > 0)
            time = rest + " days " + time;

        return time;
    }

    /**
       Retourne le rapport entre le temps CPU courant
       et le temps CPU calcule precedemment

       @return ratio entre ce temps CPU et le precedent
    */
    double getRatio()
    {
        return (double) currentTime/previousTime;
    }
}
