package logica;
import java.util.ArrayList;
public class Materia implements Comparable<Materia> {
    private String nombreMateria;
    private String codigoMateria;
    private Boolean obligatoria;
    private Boolean promocion;
    private ArrayList<Materia> correlativas; 
    private int cuatrimestre;
    private int anio;

    public Materia(String codigo, String nombreMateria, boolean obligatoria, boolean promocion, ArrayList<Materia> correlativas, int cuatrimestre, int anio) {
        this.codigoMateria = codigo;
        this.nombreMateria = nombreMateria;
        this.obligatoria = obligatoria;
        this.promocion = promocion;
        this.correlativas = correlativas != null ? correlativas : new ArrayList<>();
        this.cuatrimestre = cuatrimestre;
        this.anio = anio;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getCodigoMateria() {
        return this.codigoMateria;
    }

    public void setObligatoria(Boolean estado) {
        this.obligatoria = estado;
    }

    public Boolean getObligatoria() {
        return this.obligatoria;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    public Boolean getPromocion() {
        return this.promocion;
    }

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas != null ? correlativas : new ArrayList<>();
    }

    public ArrayList<Materia> getCorrelativas() {
        return correlativas;
    }
    
    public void setCuatrimetre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public int getCuatrimetre() {
        return cuatrimestre;
    }

    public int getAnio() {
        return anio;
    }

    public int compareTo(Materia o) {
        return Integer.compare(this.getCuatrimetre(), o.getCuatrimetre());
    }

}
