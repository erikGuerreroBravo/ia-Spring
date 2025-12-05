package mx.nube2024.ia.app.htsoft.persistence.mapper;
import mx.nube2024.ia.app.htsoft.domain.Genero;
import org.mapstruct.Named;

@Named("StringToGenero")
public class GeneroMapper {
    public static Genero stringToGenere(String genero){
        if(genero == null){
            return null;
        }
        return switch (genero.toUpperCase()){
            case "ACCION" -> genero.ACTION;
            case "COMEDIA" -> genero.COMEDY;
            case "DRAMA" -> genero.DRAMA;
            case  "ANIMADA" -> genero.ANIMATED;
            case "TERROR" ->genero.HORROR;
            case "CIENCIA_FICCION" -> genero.SCI_FI;
            default -> null;
        };
    }
    @Named("GeneroToString")
    public static String generoToString(Genero genero)
    {
        if(genero ==null)
        {
            return null;
        }
        return switch (genero){
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
        };
    }

}
