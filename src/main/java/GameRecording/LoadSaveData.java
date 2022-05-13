package GameRecording;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoadSaveData implements Serializable
{
    private static final long serialVersionUID = 1L;
    public static ArrayList<GameSave> listOfSavedGames;
    public static Context context;
    public static void loadGameData()
    {
        File f = new File(context.getFilesDir(), "data.dat");
        if(f.exists())
        {
            try
            {
                FileInputStream fis = context.openFileInput("data.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                listOfSavedGames = (ArrayList<GameSave>) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            listOfSavedGames = new ArrayList<GameSave>();
        }
    }
    public static void saveGameData()
    {
        try
        {
            FileOutputStream fos = context.openFileOutput("data.dat",0);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listOfSavedGames);
            oos.close();
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
