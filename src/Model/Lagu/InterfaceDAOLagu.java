package Model.Lagu;
import java.util.List;
public interface InterfaceDAOLagu {

    public void insertLagu(ModelLagu lagu);
    public void deleteLagu(int idLagu);
    public void updateLagu(ModelLagu lagu);
    public List<ModelLagu> getAllLagu();

}
